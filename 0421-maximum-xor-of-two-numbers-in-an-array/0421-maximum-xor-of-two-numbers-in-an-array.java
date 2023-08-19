class Node
{
    Node links[] = new Node[2];
    
    boolean containsKey(int index)
    {
        return links[index] != null;
    }
    
    void put(int index, Node temp)
    {
        links[index] = temp;
    }
    
    Node get(int index)
    {
        return links[index];
    }
}

class Trie
{
    Node root;
    
    Trie()
    {
        root = new Node();
    }
    
    void insert(int num)
    {
        Node curr = root;
        for(int i = 31; i >= 0; i--)
        {
            int bit = (num >> i) & 1;
            if(!curr.containsKey(bit))
                curr.put(bit, new Node());
            
            curr = curr.get(bit);
        }
    }
    
    int getMax(int num)
    {
        Node curr = root;
        int maxNum = 0;
        for(int i = 31; i >= 0; i--)
        {
            int bit = (num >> i) & 1;
            if(curr.containsKey(1 - bit))
            {
                maxNum = maxNum | (1 << i);
                curr = curr.get(1 - bit);
            }
            else
                curr = curr.get(bit);
        }
        return maxNum;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int i = 0; i < nums.length; i++)
            trie.insert(nums[i]);
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
            max = Math.max(max, trie.getMax(nums[i]));
        
        return max;
    }
}