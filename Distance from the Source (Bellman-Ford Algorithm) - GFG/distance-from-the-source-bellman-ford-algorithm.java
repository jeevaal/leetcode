//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        
        // if there is a negative cycle (i.e. the total waeight of the path is negative), djikstra's algo wont work because it goes into the loop
        // the reason for n - 1 iterations is because at worst case one value is updated. already we have distance for the source node, so for the remaining nodes(i.e. n - 1 nodes), we require atmost n - 1 iterations.
        // no need to create adjacencylist
        int distance[] = new int[V];
        int max = (int)1e8;
        Arrays.fill(distance, max);
    
        distance[S] = 0;
        
        for(int i = 1; i <= V - 1; i++)
        {
            for (ArrayList<Integer> it : edges) 
            {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (distance[u] != max && distance[u] + wt < distance[v])
                {
                    distance[v] = distance[u] + wt;
                }
            }
        }
        
        // for negative cycle check
        // do the nth iteration if still the value decreases then there is a negative cycle
        
        for(ArrayList<Integer> it : edges)
        {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            
            if(distance[u] != max && distance[u] + wt < distance[v])
            {
                return new int[]{-1};
            }
        }
        return distance;
    }
}