/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {
 *     }
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        //Get the end of the end of list 
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the second list
        ListNode cur = slow.next;

        //disconnects the 2 lists
        slow.next = null;
        ListNode prev = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }   

        ListNode dummy = new ListNode();
        ListNode l2 = prev;
        ListNode l1 = head;

        //Merge
        while (l1 != null && l2 != null) {

            dummy.next = l1;
            dummy = dummy.next;
            l1 = l1.next;

            dummy.next = l2;
            dummy = dummy.next;
            l2 = l2.next;
        }

        if(l1 != null){
            dummy.next = l1;
        }
        else{
            dummy.next = l2;
        }

    }
}