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
        int count=0;

        ListNode curr = new ListNode(0);
        curr.next=head;
        while(head!=null && count<n){
            head=head.next;
            count++;
        }

        ListNode nth = curr;
        while(head!=null){
            head=head.next;
            nth = nth.next;
        }

        if(nth!=null && nth.next!=null)
            nth.next = nth.next.next;

        return curr.next;
    }
}