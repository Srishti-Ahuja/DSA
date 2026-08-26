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
    ListNode mergesort(ListNode head){
        if(head==null)
            return null;

        if(head.next==null)
            return head;

        //break into 2
        ListNode slow=head, fast=head, prev=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next;
            fast=fast.next;

            prev=slow;
            slow=slow.next;
        }
        prev.next=null;

        //mergesort both individually
        ListNode l1 = mergesort(head);
        ListNode l2 = mergesort(slow);

        //merge both 
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next = l1;
                curr=l1;
                l1=l1.next;
            }
            else{
                curr.next = l2;
                curr=l2;
                l2=l2.next;
            }
        }
        if(l1!=null){
            curr.next=l1;
        }
        else if(l2!=null){
            curr.next=l2;
        }

        //return merged list
        return newHead.next;
    }
    public ListNode sortList(ListNode head) {
        return mergesort(head);
    }
}