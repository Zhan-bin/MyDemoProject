package org.example.problem.now;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class DlinkNode {
        int key;
        int value;
        DlinkNode prev;
        DlinkNode next;

        public DlinkNode() {}

        public DlinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DlinkNode(int key, int value, DlinkNode prev, DlinkNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private final int capacity;
    private DlinkNode head, tail;
    private Map<Integer, DlinkNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DlinkNode();
        tail = new DlinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        DlinkNode node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DlinkNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }

        DlinkNode node = new DlinkNode(key, value);
        cache.put(key, node);
        addToHead(node);

        if (cache.size() > capacity) {
            removeTail();
        }
    }

    private void moveToHead(DlinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DlinkNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeNode(DlinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void removeTail() {
        cache.remove(tail.prev.key);
        removeNode(tail.prev);
    }
}
