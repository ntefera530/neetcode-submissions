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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0){
            return null;
        }

        for(int i = 1; i < n; i++){
            lists[i] = merge2(lists[i],lists[i - 1]);
        }

        return lists[n - 1];
    }

    public ListNode merge2(ListNode l1 , ListNode l2){
        ListNode output = new ListNode();
        ListNode dummy = output;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            }
            else{
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }
        }
        if(l1 != null){
            dummy.next = l1;
        }
        else{
            dummy.next = l2;
        }

        return output.next;
    }
}
