package org.example.problem.history;

import java.util.HashMap;

public class LRUCache {
    static class DLinkNode {
        public int key;
        public int val;
        public DLinkNode prev;
        public DLinkNode next;
        public DLinkNode() {}
        public DLinkNode(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
        public DLinkNode(Integer key, Integer val, DLinkNode prev, DLinkNode next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    private final int capacity;
    private final DLinkNode head;
    private final DLinkNode tail;
    private HashMap<Integer, DLinkNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DLinkNode();
        this.tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DLinkNode node = cache.get(key);
            moveToHead(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            DLinkNode node = cache.get(key);
            moveToHead(node);
            return;
        }

        if (cache.size() >= capacity) {
            removeTail();
            cache.remove(tail.prev.key);
        }

        addToHead(new DLinkNode(key, val));
    }

    private void removeTail() {
        DLinkNode node = tail.prev;
        removeNode(node);
    }

    private void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
