class MyHashMap {
    private static int MAP_SIZE = 1000;

    private class ListNode {
        int key;
        int value;
        ListNode next;

        public ListNode(int key, int value, ListNode next) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public ListNode() {
            this(-1, -1, null);
        }
    }

    ListNode[] map;

    public MyHashMap() {
        map = new ListNode[MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            map[i] = new ListNode();
        }
    }
    
    public void put(int key, int value) {
        ListNode cur = map[hash(key)];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next.value = value;
                return;
            }
            cur = cur.next;
        }
        cur.next = new ListNode(key, value, null);
    }
    
    public int get(int key) {
        ListNode cur = map[hash(key)];
        while (cur.next != null) {
            if (cur.next.key == key) {
                return cur.next.value;
            }
            cur = cur.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        ListNode cur = map[hash(key)];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

    private int hash(int key) {
        return key * 19 % MAP_SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */