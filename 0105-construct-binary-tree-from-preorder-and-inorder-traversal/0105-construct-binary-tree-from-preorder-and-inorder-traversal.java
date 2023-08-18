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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> in = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            in.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, in);
    }
    
    public TreeNode build(int preorder[], int preStart, int preEnd, int inorder[], int inStart, int inEnd, HashMap<Integer, Integer> in)
    {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inHead = in.get(root.val);
        int numsLeft = inHead - inStart;
        
        root.left = build(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inHead - 1, in);
        root.right = build(preorder, preStart + numsLeft + 1, preEnd, inorder, inHead + 1, inEnd, in);
        
        return root;
    }
}