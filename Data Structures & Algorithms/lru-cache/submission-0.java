public class ListNode {
    ListNode prev;
    ListNode next;
    int val;
    int key;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    int capacity;
    ListNode head, tail;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);     
        head.next = tail;
        tail.prev = head;   
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key).val;
            remove(key);
            update(key, val);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        remove(key);
        update(key, value);
        if (map.size() > capacity) {
            remove(tail.prev.key);
        }
    }

    private void update(int key, int value) {
        ListNode node = new ListNode(key, value);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        head.next.prev = head;
        map.put(key, node);
    }

    private void remove(int key) {
        ListNode node = map.remove(key);
        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;  
        }
    }
}
