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
    ListNode reverse(ListNode head, int k){
        ListNode prev=null;
        while(head!=null && k>0){
            ListNode aux = head.next;
            head.next = prev;

            prev=head;
            head=aux;

            k--;
        }

        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0);
        ListNode groupStart, groupEnd, curr=head, traverse=newHead;
    
        while(curr!=null){
            //reverse next k
            groupEnd = curr;
            int count=0;
            while(curr!=null && count<k){
                curr=curr.next;
                count++;
            }

            if(count==k){
                groupStart = reverse(groupEnd,k);
                traverse.next = groupStart;
                traverse = groupEnd;
            }
            else{
                traverse.next = groupEnd;
            }
        }

        return newHead.next;
    }
}