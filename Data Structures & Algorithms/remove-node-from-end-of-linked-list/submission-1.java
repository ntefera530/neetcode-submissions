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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode buffer = head;

        for(int i = 0; i < n; i++){
            buffer = buffer.next;
        }

        while(buffer != null){
            prev = prev.next;
            cur = cur.next;
            buffer = buffer.next;
        }

        //remove cur
        prev.next = cur.next;

        return dummy.next;
    }
}
