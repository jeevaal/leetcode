class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        List<Integer> topo = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++)
        {
            adjacencyList.put(i, new ArrayList<>());
            indegree.put(i, 0);
        }
        
        for(int prerequisite[] : prerequisites)
        {
            int source = prerequisite[1];
            int destination = prerequisite[0];
            adjacencyList.get(source).add(destination);
            indegree.put(destination, indegree.get(destination) + 1);
        }
        
        // using bfs
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++)
            if(indegree.get(i) == 0)
                q.add(i);
        
        while(!q.isEmpty())
        {
            int temp = q.poll();
            topo.add(temp);
            for(int ele : adjacencyList.get(temp))
            {
                indegree.put(ele, indegree.get(ele) - 1);
                if(indegree.get(ele) == 0)
                    q.add(ele);
            }
        }
        
        if(topo.size() != numCourses)
            return new int[0];
        
        int res[] = new int[topo.size()];
        for(int i = 0; i < topo.size(); i++)
            res[i] = topo.get(i);
        
        return res;
    }
}