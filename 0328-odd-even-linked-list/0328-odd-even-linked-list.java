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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0), even = new ListNode(0);
        ListNode prevOdd = odd, prevEven = even;
        boolean isOdd=true;

        while(head!=null){
            if(isOdd){
                prevOdd.next = head;
                prevOdd = head;
            }
            else{
                prevEven.next = head;
                prevEven = head;
            }

            head=head.next;
            isOdd = !isOdd;
        }

        prevEven.next=null;

        prevOdd.next = even.next;
        return odd.next;
    }
}