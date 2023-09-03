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
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        if(root.val == key)
            return helper(root);
        
        TreeNode temp = root;
        
        while(temp != null)
        {
            if(temp.val > key)
            {
                if(temp.left != null && temp.left.val == key)
                {
                    temp.left = helper(temp.left);
                    return root;
                }    
                else
                    temp = temp.left;
            }
            else
            {
                if(temp.right != null && temp.right.val == key)
                {
                    temp.right = helper(temp.right);
                    return root;
                }   
                else
                    temp = temp.right;
            }
        }
        
        return root;
    }
    
    public TreeNode helper(TreeNode node)
    {
        if(node.left == null)
            return node.right;
        if(node.right == null)
            return node.left;
        
       
        TreeNode leftRightMost = node.left;
        
        while(leftRightMost.right != null)
            leftRightMost = leftRightMost.right;
        
        leftRightMost.right = node.right;
        return node.left;
    }
}