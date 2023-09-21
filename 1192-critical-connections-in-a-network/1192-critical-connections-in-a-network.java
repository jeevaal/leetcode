class Solution {
    
    private int timer = 1;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        
        for(int i = 0; i < n; i++)
        {
            adjacencyList.put(i, new ArrayList<>());
            visited.put(i, false);
        }
        
        for(int i = 0; i < connections.size(); i++)
        {
            adjacencyList.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adjacencyList.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        
        int tin[] = new int[n];
        int low[] = new int[n];
        
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, adjacencyList, visited, tin, low, bridges);
        return bridges;
    }
    
    public void dfs(int source, int parent,  HashMap<Integer, List<Integer>> adjacencyList, HashMap<Integer, Boolean> visited, int tin[], int low[], List<List<Integer>> bridges)
    {
        visited.put(source, true);
        tin[source] = low[source] = timer;
        timer++;
        
        for(int ele : adjacencyList.get(source))
        {
            if(ele == parent)
                continue;
            if(!visited.get(ele))
            {
                dfs(ele, source, adjacencyList, visited, tin, low, bridges);
                low[source] = Math.min(low[source], low[ele]);
                
                if(tin[source] < low[ele])
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(source);
                    temp.add(ele);
                    bridges.add(temp);
                }
            }
            else
                low[source] = Math.min(low[source], low[ele]);
        }
    }
}