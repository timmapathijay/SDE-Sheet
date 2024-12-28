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
    public ListNode getMiddleNode(ListNode head)
    {
        ListNode slow = head , fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseLL(ListNode head)
    {
        ListNode currentNode = head , prevNode = null , nextNode;
        while(currentNode != null)
        {
            nextNode = currentNode.next; // backup 
            currentNode.next = prevNode; // Link
            
            prevNode = currentNode;
            currentNode = nextNode;
            
        }
        return prevNode;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next == null)
          return true;
        
        ListNode middleNode = getMiddleNode(head); 
        ListNode head_LL2 = reverseLL(middleNode.next); 
        
        middleNode.next = null;
        
        ListNode traversalPointer_LL1 = head , traversalPointer_LL2 = head_LL2;
        boolean isPalindrome = true;
        
        while(traversalPointer_LL1 != null && traversalPointer_LL2 != null) 
        {
           if(traversalPointer_LL1.val != traversalPointer_LL2.val)
           {
               isPalindrome = false;
               break;
           }
           
           traversalPointer_LL1 = traversalPointer_LL1.next;
           traversalPointer_LL2 = traversalPointer_LL2.next; 
        }
        
        middleNode.next = reverseLL(head_LL2);
        return isPalindrome;
    }
}
