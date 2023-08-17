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
    public int kthSmallest(TreeNode root, int k) {
        // using iterative inorder traversal
        Stack<TreeNode> s = new Stack<>();
        int count = 0;
        while(true)
        {
            if(root != null)
            {
                s.push(root);
                root = root.left;
            }
            else
            {
                if(s.isEmpty())
                    break;
                
                root = s.pop();
                count++;
                if(count == k)
                    return root.val;
                root = root.right;
            }
        }
        return 0;
    }
}