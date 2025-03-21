package org.example.LRU;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class User {
    private String userId;
    private int age;

    public User(String userId, int age) {
        this.userId = userId;
        this.age = age;
    }

    public String getUserId() { return userId; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "User{userId='" + userId + "', age=" + age + "}";
    }
}

class Node {
    String key;
    User value;
    Node prev;
    Node next;
    long timestamp;  // 最后访问时间

    public Node(String key, User value) {
        this.key = key;
        this.value = value;
        this.timestamp = System.currentTimeMillis();
    }

    public void updateTimestamp() {
        this.timestamp = System.currentTimeMillis();
    }
}

class LRUCache {
    private final int capacity;
    private final Map<String, Node> map = new HashMap<>();
    private Node head, tail;
    private final ScheduledExecutorService scheduler;
    private static final long CLEANUP_INTERVAL = 30; // 30秒
    private static final long EXPIRE_TIME = 30 * 60 * 1000; // 30分钟

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node("", null);
        tail = new Node("", null);
        head.next = tail;
        tail.prev = head;
        scheduler = Executors.newScheduledThreadPool(1);
        startCleaner();
    }

    private void startCleaner() {
        scheduler.scheduleAtFixedRate(this::cleanExpiredEntries,
                CLEANUP_INTERVAL, CLEANUP_INTERVAL, TimeUnit.SECONDS);
    }

    public User get(String key) {
        synchronized (this) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                moveToHead(node);
                node.updateTimestamp();
                return node.value;
            }
        }
        // 缓存未命中时查询数据库
        User user = MysqlUtil.queryUser(key);
        if (user != null) {
            put(key, user);
        }
        return user;
    }

    public void put(String key, User value) {
        synchronized (this) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                node.updateTimestamp();
                moveToHead(node);
                return;
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);

            if (map.size() > capacity) {
                Node last = removeTail();
                map.remove(last.key);
            }
        }
    }

    private void cleanExpiredEntries() {
        synchronized (this) {
            long currentTime = System.currentTimeMillis();
            Node curr = tail.prev;
            while (curr != head && currentTime - curr.timestamp > EXPIRE_TIME) {
                Node prev = curr.prev;
                removeNode(curr);
                map.remove(curr.key);
                curr = prev;
            }
        }
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}

// 数据库工具类（模拟实现）
class MysqlUtil {
    public static User queryUser(String userId) {
        System.out.println("[DB] Querying user: " + userId);
        return new User(userId, 25); // 模拟数据库返回
    }

    public static void updateUser(User user) {
        System.out.println("[DB] Updating user: " + user.getUserId());
    }
}

// 测试示例
public class UserLRUCache {
    public static void main(String[] args) throws InterruptedException {
        LRUCache cache = new LRUCache(2);

        // 测试基本功能
        System.out.println("Test1: Basic operations");
        System.out.println(cache.get("user1"));  // 从数据库加载
        System.out.println(cache.get("user1"));  // 从缓存获取

        // 测试容量淘汰
        System.out.println("\nTest2: Capacity eviction");
        cache.put("user2", new User("user2", 30));
        cache.put("user3", new User("user3", 35));
        System.out.println(cache.get("user1"));  // 应该触发数据库查询

        // 测试过期清理
        System.out.println("\nTest3: Expiration cleanup");
        Thread.sleep(35000);  // 等待清理任务执行
        System.out.println(cache.get("user2"));  // 应该已过期
    }
}
