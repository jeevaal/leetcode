//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends




/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int topo[] = new int[V];
        
        // using bfs
        // int indegree[] = new int[V];
        
        // //finding indegree
        // for(int i = 0;i<V;i++) {
        //     for(int it: adj.get(i)) {
        //         indegree[it]++;
        //     }
        // }
        // Queue<Integer> q = new LinkedList<Integer>();
        // for(int i = 0;i<V;i++) {
        //     //adding nodes to queue with indegree = 0
        //     if(indegree[i] == 0) {
        //         q.add(i);
        //     }
        // }
        
        // int ind=0;
        
        // while(!q.isEmpty()) {
        //     int node = q.poll();
        //     topo[ind++] = node;
            
        //     //getting neighbour nodes of popped node and decreasing  their indegree by1
        //     for(int it: adj.get(node)) {
        //         indegree[it]--;
        //         if(indegree[it] == 0) {
        //             q.add(it);
        //         }
        //     }
        // }
        
        // using dfs
        Stack<Integer> s = new Stack<Integer>();
        int vis[] = new int[V];
        for(int i = 0; i < V; i++)
        {
            if(vis[i] == 0)
                topoUsingDfs(0, V, s, adj, vis);
        }
        for(int i = 0; i < V; i++)
            topo[i] = s.pop();
        return topo;
        
    }
    // recursive dfs, element should be stored at last
    static void topoUsingDfs(int source, int V, Stack<Integer> s, ArrayList<ArrayList<Integer>> adj, int vis[])
    {
        vis[source] = 1;
        for(int e : adj.get(source))
        {
            if(vis[e] == 0)
                topoUsingDfs(e, V, s, adj, vis);
        }
        s.push(source);
    }
}
