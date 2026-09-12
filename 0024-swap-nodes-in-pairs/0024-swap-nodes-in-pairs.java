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
    public ListNode swapPairs(ListNode head) {
        ListNode curr=head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;

        while(curr!=null && curr.next!=null){
            ListNode first = curr;
            ListNode second = curr.next;
            ListNode next = second.next;

            second.next = first;
            first.next = next;
            prev.next = second;
            prev = first;

            curr = next;
        }
        return newHead.next;
    }
}