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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> in = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            in.put(inorder[i], i);
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, in);
    }
    
    public TreeNode build(int inorder[], int inStart, int inEnd, int postorder[], int postStart, int postEnd, HashMap<Integer, Integer> in)
    {
        if(inStart > inEnd || postStart > postEnd)
            return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        int inHead = in.get(root.val);
        int numsLeft = inHead - inStart;
        
        root.left = build(inorder, inStart, inHead - 1, postorder, postStart, postStart + numsLeft - 1, in);
        root.right = build(inorder, inHead + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, in);
        
        return root;
    }
}