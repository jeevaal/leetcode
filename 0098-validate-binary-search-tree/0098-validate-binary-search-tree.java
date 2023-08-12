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
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean check(TreeNode root, long lowerBound, long upperBound)
    {
        if(root == null)
            return true;
        
        if(root.val <= lowerBound || root.val >= upperBound)
            return false;
        
        return check(root.left, lowerBound, root.val) && check(root.right, root.val, upperBound);
    }
}