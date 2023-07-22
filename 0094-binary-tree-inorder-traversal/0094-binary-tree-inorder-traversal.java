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
    public List<Integer> inorderTraversal(TreeNode root) {
        
//         List<Integer> l = new ArrayList<>();
        
//         Stack<TreeNode> s = new Stack<TreeNode>();
        
//         while(true)
//         {
//             if(root != null)
//             {
//                 s.push(root);
//                 root = root.left;
//             }
//             else
//             {
//                 if(s.isEmpty())
//                     break;
//                 root = s.pop();
//                 l.add(root.val);
//                 root = root.right;
//             }
//         }
//         return l;
        
        // Morris Inoreder traversal with space complexity of O(1)
        List<Integer> l = new ArrayList<>();
        
        while(root != null)
        {
            if(root.left == null)
            {
                l.add(root.val);
                root = root.right;
            }
            else
            {
                TreeNode temp = root.left;
                while(temp.right != null && temp.right != root)
                    temp = temp.right;
                
                if(temp.right == null)
                {
                    temp.right = root;
                    root = root.left;
                }
                else
                {
                    temp.right = null;
                    l.add(root.val);
                    root = root.right;
                }
            }
        }
        
        return l;
        
    }
}