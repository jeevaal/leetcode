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
    // without creating a node
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         if(list1 == null)
//             return list2;
//         if(list2 == null)
//             return list1;
//         // considering always l should be smallest
//         if(list1.val > list2.val)
//         {
//             ListNode temp = list1;
//             list1 = list2;
//             list2 = temp;
//         }
        
//         ListNode head = list1;
        
//         while(list1 != null && list2 != null)
//         {
//             ListNode temp1 = null;
//             while(list1 != null && list1.val <= list2.val)
//             {
//                 temp1 = list1;
//                 list1 = list1.next;
//             }
//             temp1.next = list2;
            
//             ListNode temp = list1;
//             list1 = list2;
//             list2 = temp;
//         }
        
//         return head;
//     }
    
    // with creating a node
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        // considering always l should be smallest
        
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        
        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }
            else
            {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        
        if(list1 != null)
            temp.next = list1;
        else
            temp.next = list2;
        
        return res.next;
    }
}