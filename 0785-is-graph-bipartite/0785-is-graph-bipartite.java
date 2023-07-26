class Solution {
    public boolean isBipartite(int[][] graph) {
        // here given input is adjacencyList
        // bfs -- instead of visited , use coloured 
        // fill with 0s and 1s alternatively
        int n = graph.length;
        int coloured[] = new int[n];
        Arrays.fill(coloured, -1);
        
        for(int i = 0; i < n; i++)
        {
            if(coloured[i] == -1)
                if(check(i, graph, coloured) == false)
                    return false;
        }
        
        return true;
    }
    
    public boolean check(int source, int graph[][], int coloured[])
    {
        // using bfs
//         Queue<Integer> q = new LinkedList<>();
//         q.add(source);
//         coloured[source] = 0;
//         while(!q.isEmpty())
//         {
//             int node = q.poll();
//             for(int i : graph[node])
//             {
//                 if(coloured[i] == -1)
//                 {
//                     q.add(i);
//                     coloured[i] = 1 - coloured[node];
//                 }
//                 else if(coloured[i] == coloured[node])
//                 {
//                     return false;
//                 }
                    
//             }
//         }
//         return true;
        
        // using dfs
        Stack<Integer> q = new Stack<>();
        q.push(source);
        coloured[source] = 0;
        while(!q.isEmpty())
        {
            int node = q.pop();
            for(int i : graph[node])
            {
                if(coloured[i] == -1)
                {
                    q.push(i);
                    coloured[i] = 1 - coloured[node];
                }
                else if(coloured[i] == coloured[node])
                {
                    return false;
                }
                    
            }
        }
        return true;
    }
    
}