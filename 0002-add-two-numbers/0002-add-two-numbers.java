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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1, temp2=l2, head=new ListNode(0), prev=head;

        int sum=0, carry=0;

        while(temp1!=null || temp2!=null){
            sum=carry;
            if(temp1!=null){
                sum+=temp1.val;
                temp1=temp1.next;
            }
            if(temp2!=null){
                sum+=temp2.val;
                temp2=temp2.next;
            }

            carry=sum/10;
            ListNode curr = new ListNode(sum%10);
            prev.next=curr;
            prev=curr;
        }

        while(carry>0){
            ListNode curr = new ListNode(carry%10);
            prev.next=curr;
            prev=curr;
            carry/=10;
        }

        return head.next;
    }
}