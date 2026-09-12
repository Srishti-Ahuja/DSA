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
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode slow=head, fast=head, prev=newHead;

        while(n > 0 && fast!=null){
            fast=fast.next;
            n--;
        }

        while(fast!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }

        //System.out.println(prev.val);
        if(prev!=null)
            prev.next=prev.next.next;

        return newHead.next;
    }
}