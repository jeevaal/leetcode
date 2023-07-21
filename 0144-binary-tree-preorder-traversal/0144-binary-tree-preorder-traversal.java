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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        
        Stack<TreeNode> s = new Stack<>();
        
        while(true)
        {
            if(root != null)
            {
                s.push(root);
                l.add(root.val);
                root = root.left;
            }
            else
            {
                if(s.isEmpty())
                    break;
                root = s.pop();
                root = root.right;
            }
        }
        return l;
    }
}