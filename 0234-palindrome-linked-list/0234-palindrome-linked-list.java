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
    ListNode reverse(ListNode head){
        ListNode curr=head, prev=null;

        while(curr!=null){
            ListNode aux = curr.next;
            curr.next = prev;
            prev = curr;
            curr = aux;
        }

        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        //find mid
        ListNode prev = new ListNode(0);
        prev.next=head;
        ListNode mid = prev, fast = prev;
        while(fast!=null){
            fast=fast.next;

            if(fast!=null){
                fast=fast.next;
                mid=mid.next;
            }
        }

        //reverse 2nd half
        ListNode head2 = reverse(mid);

        //compare 2 LLs
        while(head!=null){
            if(head.val!=head2.val)
                return false;

            head = head.next;
            head2 = head2.next;
        }

        return true;
    }
}