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
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0, head);
        ListNode prev = root, cur = head;

        while (cur != null && cur.next != null) {
            ListNode nextStart = cur.next.next;
            ListNode next = cur.next;

            // Swap
            prev.next = next;
            next.next = cur;
            cur.next = nextStart;

            // Set Pointers
            prev = cur;
            cur = nextStart;
        }

        return root.next;
    }
}
