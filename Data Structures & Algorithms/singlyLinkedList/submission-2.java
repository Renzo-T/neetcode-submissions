class Node {
    int val;
    Node next;

    public Node(int val) {
        this(val, null);
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    

    Node head;
    Node tail;

    public LinkedList() {
        head = new Node(-1);
        tail = head;
    }

    public int get(int index) {
        Node curr = head.next;
        int i = 0;
        while(curr != null) {
            if (i == index) {
                return curr.val;
            }
            i++;
            curr = curr.next;
        }
        return  -1;
    }

    public void insertHead(int val) {
        Node node = new Node(val, head.next);
        head.next = node;
        if (node.next == null) {
            tail = node;
        }
    }

    public void insertTail(int val) {
        Node node = new Node(val);
        tail.next = node;
        tail = node;
    }

    public boolean remove(int index) {
        Node curr = head;
        int i = -1;
        while(curr != null && curr.next != null) {
            if (i+1 == index) {
                if (curr.next == tail) {
                    tail = curr;
                }
                curr.next = curr.next.next;
                return true;
            }
            i++;
            curr = curr.next;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> results = new ArrayList<>();
        Node curr = this.head.next;
        while (curr != null) {
            results.add(curr.val);
            curr = curr.next;
        }
        return results;
    }
}
