class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        List<Integer> topo = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacencyList.put(i, new ArrayList<>());
            indegree.put(i, 0);
        }

        for (int[] prerequisite : prerequisites) {
            int source = prerequisite[1];
            int destination = prerequisite[0];
            addEdge(source, destination, adjacencyList, indegree);
        }
//         using bfs
//         Queue<Integer> q = new LinkedList<>();
        
//         for(int i = 0; i < numCourses; i++)
//         {
//             if(indegree.get(i) == 0)
//                 q.add(i);
//         }

//         while (!q.isEmpty()) {
//             int node = q.poll();
//             topo.add(node);
//             for (int neighbor : adjacencyList.get(node)) {
//                 indegree.put(neighbor, indegree.get(neighbor) - 1);
//                 if (indegree.get(neighbor) == 0) {
//                     q.add(neighbor);
//                 }
//             }
//         }
        
        Stack<Integer> q = new Stack<>();
        
        for(int i = 0; i < numCourses; i++)
        {
            if(indegree.get(i) == 0)
                q.push(i);
        }

        while (!q.isEmpty()) {
            int node = q.pop();
            topo.add(node);
            for (int neighbor : adjacencyList.get(node)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    q.push(neighbor);
                }
            }
        }

        return topo.size() == numCourses; 
    }

    public void addEdge(int source, int destination, HashMap<Integer, List<Integer>> adjacencyList, HashMap<Integer, Integer> indegree) {
        adjacencyList.get(source).add(destination);
        indegree.put(destination, indegree.get(destination) + 1);
    }
}

