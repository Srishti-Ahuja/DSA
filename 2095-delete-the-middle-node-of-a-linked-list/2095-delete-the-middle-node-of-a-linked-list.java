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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)
            return null;
            
        ListNode start = new ListNode(0);
        ListNode prev = start;
        start.next=head;
        ListNode slow=start, fast=start;

        while(fast!=null){
            fast=fast.next;
            prev=slow;
            slow=slow.next;

            if(fast!=null){
                fast=fast.next;
            }
        }

        if(prev.next!=null)
            prev.next = prev.next.next;

        return head;
    }
}