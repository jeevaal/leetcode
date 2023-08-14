//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Pair
{
    int distance;
    int node;
    
    Pair(int distance, int node)
    {
        this.distance = distance;
        this.node = node;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // if need to print the edges of the spanning tree a third variable called parent can be used in Pair.
	    
	    // adjacencyList with cost
	    HashMap<Integer, List<List<Integer>>> adjacencyList = new HashMap<>();
	    for(int i = 0; i < V; i++)
	        adjacencyList.put(i, new ArrayList<>());
	   
	    for(int i = 0; i < E; i++)
	    {
	        adjacencyList.get(edges[i][0]).add(Arrays.asList(edges[i][1], edges[i][2]));
	        adjacencyList.get(edges[i][1]).add(Arrays.asList(edges[i][0], edges[i][2]));
	    }
	    
	    int total = 0;
	    PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> (x.distance - y.distance));
	    int visited[] = new int[V];
	    pq.add(new Pair(0, 0));
	    while(!pq.isEmpty())
	    {
	        int distance = pq.peek().distance;
	        int node = pq.peek().node;
	        pq.remove();
	        
	        if(visited[node] == 1)
	            continue;
	            
	        visited[node] = 1;
	        total += distance;
	        
	        for(List<Integer> l : adjacencyList.get(node))
	        {
	            int n = l.get(0);
	            if(visited[n] == 0)
	                pq.add(new Pair(l.get(1), n));
	        }
	    }
	    return total;
	}
}