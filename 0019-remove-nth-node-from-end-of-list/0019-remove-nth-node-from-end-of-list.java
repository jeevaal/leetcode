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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode temp1 = temp;
        ListNode temp2 = temp;
        int count = 0;
        while(count < n)
        {
            temp1 = temp1.next;
            count++;
        }
        while(temp1.next != null)
        {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;
        return temp.next;
    }
}