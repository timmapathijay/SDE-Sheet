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
    public ListNode reverseList(ListNode head) {
        ListNode currNode = head , prevNode = null;
        while(currNode != null)
        {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }
}
// TC : O(N)
// SC : O(1)

class Solution {
    public ListNode reverseLL(ListNode currNode , ListNode head)
    {
        if(currNode.next == null)
        {
            head = currNode;
            return head;
        }
        head = reverseLL(currNode.next , head);
        ListNode nextNode = currNode.next;
        nextNode.next = currNode;
        currNode.next = null;
        return head;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null)
        return head;
        head = reverseLL(head , head);
        return head;
        
    }
}
// TC : O(N)
// SC : O(N)[Recursive-stack space]
