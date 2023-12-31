//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> res = new ArrayList<>();
        solve(0, s, res, "");
        Collections.sort(res);
        res.remove(0);// removing space
        return res;
    }
    
    public void solve(int index, String s, List<String> res, String temp)
    {
        if(index == s.length())
        {
            res.add(temp);
            return;
        }
        
        // pick
        solve(index + 1, s, res, temp + s.charAt(index));
        
        // not pick
        solve(index + 1, s, res, temp);
    }
}