/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp1 = head, temp2 = head;
        while(temp1 != null)
        {
            temp2 = temp1.next;
            Node copy = new Node(temp1.val);
            temp1.next = copy;
            copy.next = temp2;
            temp1 = temp2;
        }
        
        temp1 = head;
        while(temp1 != null)
        {
            if(temp1.random != null)
                temp1.next.random = temp1.random.next;
            temp1 = temp1.next.next;
        }
        
        temp1 = head;
        temp2 = head;
        Node dummy = new Node(0);
        Node temp = dummy;
        
        while(temp1 != null)
        {
            temp2 = temp1.next.next;
            temp.next = temp1.next;
            temp1.next = temp2;
            temp = temp.next;
            temp1 = temp2;
        }
        return dummy.next;
    }
}