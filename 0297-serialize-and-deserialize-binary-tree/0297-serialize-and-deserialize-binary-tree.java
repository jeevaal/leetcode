/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        
        String s = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node == null)
            {
                s += "n ";
                continue;
            }
            s += String.valueOf(node.val) + " ";
            q.add(node.left);
            q.add(node.right);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "")
            return null;
        
        String arr[] = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        for(int i = 1; i < arr.length; i++)
        {
            TreeNode node = q.poll();
            if(!arr[i].equals("n"))
            {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                node.left = left;
                q.add(node.left);
            }
            i++;
            if(!arr[i].equals("n"))
            {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                node.right = right;
                q.add(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));