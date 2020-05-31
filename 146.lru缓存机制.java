/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {

    class DListNode<K, V> {

    public K key;
    public V value;

    public DListNode pre;
    public DListNode next;

    }

    Map<Integer, DListNode> cache;

    DListNode<Integer, Integer> head;
    DListNode<Integer, Integer> tail;

    int capacity;
    int count;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        head = new DListNode<>();
        tail = new DListNode<>();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    private DListNode removeTail() {
        DListNode res = tail.pre;

        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;

        return res;
    }

    private void addHead(DListNode addNode) {
        addNode.next = head.next;
        addNode.pre = head;

        head.next.pre = addNode;
        head.next = addNode;
    }

    private void removeNode(DListNode delNode) {
        delNode.pre.next = delNode.next;
        delNode.next.pre = delNode.pre;
    }

    private void moveToHead(DListNode node) {
        removeNode(node);
        addHead(node);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            // 更新链表
            moveToHead(cache.get(key));
            return (Integer) cache.get(key).value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DListNode node = cache.get(key);
        if (cache.containsKey(key)) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new DListNode();
            node.key = key;
            node.value = value;
            cache.put(key, node);
            addHead(node);
            ++ count;

            if (count > capacity) {
                // 超出大小
                DListNode delNode = removeTail();
                cache.remove(delNode.key);
                count--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

