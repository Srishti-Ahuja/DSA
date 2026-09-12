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
        if(head==null)
            return null;
            
        ListNode slow=head, fast=head;

        while(true){
            slow=slow.next;
            fast=fast.next;
            if(fast!=null)
                fast=fast.next;

            if(fast==null)
                return null;

            if(slow==fast)
                break;
        }

        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;
    }
}