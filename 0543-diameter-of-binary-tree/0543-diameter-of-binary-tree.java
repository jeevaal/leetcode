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
    public int diameterOfBinaryTree(TreeNode root) {
        int maxi[] = new int[1];
        diameter(root, maxi);
        return maxi[0];
    }
    
    public int diameter(TreeNode node, int maxi[])
    {
        if(node == null)
            return 0;
        
        int leftHeight = diameter(node.left, maxi);
        int rightHeight = diameter(node.right, maxi);
        
        maxi[0] = Math.max(maxi[0], leftHeight + rightHeight);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}