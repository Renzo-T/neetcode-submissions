/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode head = new ListNode();
        ListNode curr = head;
        while (l1 != null || l2 != null || carry) {
            int sum = carry ? 1 : 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum >= 10;
            sum %= 10;

            ListNode next = new ListNode(sum);
            curr.next = next;
            curr = curr.next;
        }
        
        return head.next;
    }
}
