/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class BstIterator
{
    Stack<TreeNode> s = new Stack<>();
    boolean reverse = true;
    
    public BstIterator(TreeNode node, boolean reverse)
    {
        this.reverse = reverse;
        pushAll(node);
    }
    
    public boolean hasNext()
    {
        return !s.isEmpty();
    }
    
    public int next()
    {
        TreeNode temp = s.pop();
        if(reverse)
        {
            if(temp.left != null)
                pushAll(temp.left);
        }
        else
        {
            if(temp.right != null)
                pushAll(temp.right);
        }
        return temp.val;
    }
    
    public void pushAll(TreeNode node)
    {
        if(reverse)
        {
            while(node != null)
            {
                s.push(node);
                node = node.right;
            }
        }
        else
        {
            while(node != null)
            {
                s.push(node);
                node = node.left;
            }
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BstIterator bi1 = new BstIterator(root, false);
        BstIterator bi2 = new BstIterator(root, true);
        
        int i = bi1.next();
        int j = bi2.next();
        
        while(i < j)
        {
            int sum = i + j;
            if(sum == k)
                return true;
            else if(sum < k)
                i = bi1.next();
            else
                j = bi2.next();
        }
        return false;
    }
}