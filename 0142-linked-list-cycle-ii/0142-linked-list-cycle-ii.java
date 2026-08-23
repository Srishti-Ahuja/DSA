/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head, slow=head, slow2=head;

        while(fast!=null){
            fast=fast.next;

            if(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }

            if(fast==slow)
                break;
        }

        if(fast!=slow)
            return null;

        while(slow!=slow2){
            slow=slow.next;
            slow2=slow2.next;
        }

        return slow;
    }
}