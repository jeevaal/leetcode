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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = null;
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
                temp = s.peek().right;
                if(temp == null)
                {
                    temp = s.pop();
                    l.add(temp.val);
                    
                    while(!s.isEmpty() && temp == s.peek().right)
                    {
                        temp = s.pop();
                        l.add(temp.val);
                    }
                }
                else
                {
                    root = temp;
                }
            }
        }
        
        return l;
    }
}