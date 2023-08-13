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
    public TreeNode sortedArrayToBST(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        return rec(low, high, nums);
    }
    public TreeNode rec(int low, int high, int nums[])
    {
        if(low > high)
            return null;
        
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = rec(low, mid - 1, nums);
        node.right = rec(mid + 1, high, nums);
        return node;
    }
}