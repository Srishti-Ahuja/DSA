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
        ListNode prev=null, curr=head, aux;

        while(curr!=null){
            aux=curr.next;
            curr.next=prev;
            prev=curr;
            curr=aux;
        }

        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head, fast=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
            if(fast!=null)
                fast=fast.next;
        }

        ListNode reversed = reverse(slow);
        while(head!=null && reversed!=null){
            if(head.val!=reversed.val)
                return false;

            head=head.next;
            reversed=reversed.next;
        }

        return true;
    }
}