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
    public int maxPathSum(TreeNode root) {
        int maxPath[] = new int[1];
        maxPath[0] = Integer.MIN_VALUE;
        find(root, maxPath);
        return maxPath[0];
    }
    
    public int find(TreeNode root, int maxPath[])
    {
        // base case
        if(root == null)
            return 0;
        
        int left = Math.max(0, find(root.left, maxPath));
        int right = Math.max(0, find(root.right, maxPath));
        
        maxPath[0] = Math.max(maxPath[0], root.val + left + right);
            
        return root.val + Math.max(left, right);
    }
}