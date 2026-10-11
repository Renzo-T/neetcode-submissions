/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        duplicate(head);
        assignRandom(head);
        Node dummy = new Node(-1);
        Node curr = dummy;

        while (head != null) {
            curr.next = head.next;  // copy
            curr = curr.next;

            head.next = head.next.next; // restore original
            head = head.next;
        }

        return dummy.next;
    }

    private void duplicate(Node head) {
        while (head != null) {
            Node next = head.next;
            Node copy = new Node(head.val);
            copy.next = next;
            copy.random = head.random;
            head.next = copy;
            head = head.next.next;
        }
    }
    
    private void assignRandom(Node head) {
        while (head != null) {
            head = head.next;
            if (head.random != null) {
                head.random = head.random.next;
            }
            head = head.next;
        }
    }

}
