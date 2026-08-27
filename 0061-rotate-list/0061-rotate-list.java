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
    int count(ListNode head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }

        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null || k==0) {
            return head;
        }

        ListNode tail = head;
        int n = 1;

        while(tail!=null && tail.next!=null){
            tail=tail.next;
            n++;
        }

        k%=n;
        if(k==0)
            return head;

        tail.next=head;

        ListNode curr = head;
        k=n-k-1;
        while(k>0){
            curr = curr.next;
            k--;
        }
        head = curr.next;
        curr.next=null;
        return head;
    }
}