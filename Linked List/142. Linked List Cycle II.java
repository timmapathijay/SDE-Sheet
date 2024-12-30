/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Floyd's cycle detection
    public ListNode cycleDetection(ListNode head)
    {
        if(head == null || head.next == null)
        return null;
        ListNode slow = head , fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            return slow;
        }
        return null;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode meetNode = cycleDetection(head);
        if(meetNode != null)
        {
           ListNode start = head;
           while(start != meetNode)
           {
              start = start.next;
              meetNode = meetNode.next;
           }
           return start;
        }
        return null;
    }
}
