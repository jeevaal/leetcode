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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middle(head);
        mid.next = reverse(mid.next);
        mid = mid.next;
        ListNode start = head;
        while(mid != null)
        {
            if(start.val != mid.val)
                return false;
            else
            {
                start = start.next;
                mid = mid.next;
            }
        }
        
        return true;
        
    }
    
    public ListNode middle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverse(ListNode head)
    {
        ListNode newHead = null;
        while(head != null)
        {
            ListNode current = head.next;
            head.next = newHead;
            newHead = head;
            head = current;
        }
        return newHead;
    }
}