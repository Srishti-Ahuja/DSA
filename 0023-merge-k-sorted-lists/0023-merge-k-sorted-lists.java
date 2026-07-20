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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));

        for(int i=0; i<lists.length; i++){
            if(lists[i]!=null)
                heap.add(lists[i]);
        }

        ListNode prev = null, head=null;
        while(!heap.isEmpty()){
            ListNode curr = heap.poll();

            if(head==null){
                head=curr;
            }

            if(curr.next!=null){
                heap.add(curr.next);
            }

            if(prev!=null)
                prev.next = curr;

            prev = curr;
        }

        return head;
    }
}