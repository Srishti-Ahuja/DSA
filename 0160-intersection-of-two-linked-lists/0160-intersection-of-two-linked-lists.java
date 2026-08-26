/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    int length(ListNode node){
        int count=0;
        while(node!=null){
            count++;
            node = node.next;
        }

        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = length(headA);
        int b = length(headB);

        ListNode tempA = headA, tempB = headB;
        if(a>b){
            a-=b;
            while(a>0){
                tempA=tempA.next;
                a--;
            }
        }
        else{
            b-=a;
            while(b>0){
                tempB=tempB.next;
                b--;
            }
        }

        while(tempA!=null){
            if(tempA==tempB)
                return tempA;

            tempA=tempA.next;
            tempB=tempB.next;
        }

        return null;
    }
}