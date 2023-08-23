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
    int x;//taken in reverse order according ti the question
    int y;
    
    Pair(TreeNode node, int x, int y)
    {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        while(!q.isEmpty())
        {
            TreeNode temp = q.peek().node;
            int x = q.peek().x;
            int y = q.peek().y;
            
            q.poll();
            
            if(!map.containsKey(x))
                map.put(x, new TreeMap<>());
            if(!map.get(x).containsKey(y))
                map.get(x).put(y, new PriorityQueue<>());
            
            map.get(x).get(y).add(temp.val);
            
            if(temp.left != null)
                q.add(new Pair(temp.left, x - 1, y + 1));
            if(temp.right != null)
                q.add(new Pair(temp.right, x + 1, y + 1));
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> x : map.values())
        {
            // res.add(new ArrayList<>());
            List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> y : x.values())
            {
                while(!y.isEmpty())
                    temp.add(y.poll());
            }
            res.add(temp);
        }
        
        return res;
    }
}