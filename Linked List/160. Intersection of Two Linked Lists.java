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
    public int getLengthOfLL(ListNode head)
    {
        ListNode traversalPointer = head;
        int lengthOfLL = 0;
        while(traversalPointer != null)
        {
            lengthOfLL += 1;
            traversalPointer = traversalPointer.next;
        }
        
        return lengthOfLL;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        int lengthOfLL1 = getLengthOfLL(headA);// N
        int lengthOfLL2 = getLengthOfLL(headB);// M
        
        // Cover the difference. O(M-N)
        ListNode traversalPointer_LL1 = headA, traversalPointer_LL2 = headB;
        int difference = Math.abs(lengthOfLL1 - lengthOfLL2);
        
        if(lengthOfLL1 > lengthOfLL2)
        {
            while(difference-- > 0)
             traversalPointer_LL1 = traversalPointer_LL1.next; 
        }
        else
        {
           while(difference-- > 0)
            traversalPointer_LL2 = traversalPointer_LL2.next; 
        }
        
        while(traversalPointer_LL1 != traversalPointer_LL2) // O(N)
        {
           traversalPointer_LL1 = traversalPointer_LL1.next;
           traversalPointer_LL2 = traversalPointer_LL2.next; 
        }
        
        return traversalPointer_LL1;
    }
}
