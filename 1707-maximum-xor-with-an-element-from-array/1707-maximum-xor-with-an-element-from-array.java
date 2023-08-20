class Node
{
    Node links[] = new Node[2];
    
    boolean containsKey(int index)
    {
        return links[index] != null;
    }
    
    void put(int index, Node newNode)
    {
        links[index] = newNode;
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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        
        int res[] = new int[m];
        Arrays.fill(res, -1);
        
        Arrays.sort(nums);
        
        List<List<Integer>> offlinequeries = new ArrayList<>();
        for(int i = 0; i < m; i++)
        {
            List<Integer> temp = new ArrayList<>();
            temp.add(queries[i][1]);
            temp.add(queries[i][0]);
            temp.add(i);
            offlinequeries.add(temp);
        }
        
        Collections.sort(offlinequeries, new Comparator<List<Integer>>(){
            public int compare(List<Integer> l1, List<Integer> l2)
            {
                return l1.get(0) - l2.get(0);
            }
        });
        
        Trie trie = new Trie();
        
        int index = 0;
        for(int i = 0; i < m; i++)
        {
            while(index < n && nums[index] <= offlinequeries.get(i).get(0))
            {
                trie.insert(nums[index]);
                index++;
            }
            
            int indexToStore = offlinequeries.get(i).get(2);
            if(index != 0)
                res[indexToStore] = trie.getMax(offlinequeries.get(i).get(1));
            else
                res[indexToStore] = -1;
        }
        return res;
    }
}