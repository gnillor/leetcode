/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start

import java.util.Map;

class LRUCache {
    private int capacity;
    private Map<Integer, DLinkedNode> cache;
    private DLinkedNode head;
    private DLinkedNode tail;

    private class DLinkedNode {
        public int key;
        public int val;
        public DLinkedNode prev;
        public DLinkedNode next;
        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void delNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new DLinkedNode(0, 0);
        this.tail = new DLinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        DLinkedNode node = cache.get(key);
        delNode(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            node.val = value;
            delNode(node);
            addNode(node);
            return;
        }

        if (cache.size() == capacity) {
            DLinkedNode lastNode = tail.prev;
            delNode(lastNode);
            cache.remove(lastNode.key);
        }

        DLinkedNode node = new DLinkedNode(key, value);
        addNode(node);
        cache.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

