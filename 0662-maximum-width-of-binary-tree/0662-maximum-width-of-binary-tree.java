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
class Pair
{
    TreeNode node;
    int num;
    Pair(TreeNode node, int num)
    {
        this.node = node;
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        int ans = 0;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            int min = q.peek().num;
            
            int start= 0, end = 0;
            
            for(int i = 0; i < size; i++)
            {
                int id = q.peek().num - min;
                
                if(i == 0)
                    start = id;
                else if(i == size - 1)
                    end = id;
                
                ans = Math.max(end - start + 1, ans);
                
                TreeNode temp = q.peek().node;
                q.poll();
                
                if(temp.left != null)
                    q.add(new Pair(temp.left, 2 * id + 1));
                
                if(temp.right != null)
                    q.add(new Pair(temp.right, 2 * id + 2));
            }
        }
        
        return ans;
        
    }
}