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
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        
        rootToAllLeafPaths(root, list, "");
        
        for(int i = 0; i < list.size(); i++)
            list.set(i, list.get(i).substring(2));
        
        return list;
    }
    
    public void rootToAllLeafPaths(TreeNode node, List<String> list, String s)
    {
        if(node == null)
            return;
        
        s += ("->" + node.val);
        
        if(node.left == null && node.right == null)
            list.add(s);
        
        rootToAllLeafPaths(node.left, list, s);
        rootToAllLeafPaths(node.right, list, s);
    }
}