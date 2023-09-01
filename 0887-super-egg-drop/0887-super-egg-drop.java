class Solution {
    public int superEggDrop(int k, int n) {
        int dp[][] = new int[k + 1][n + 1];
        for(int row[] : dp)
            Arrays.fill(row, -1);
        return solve(k, n, dp);
    }
    
    public int solve(int k, int n, int dp[][])
    {
        if(n <= 1)
            return n;
        if(k == 1)
            return n;
        
        if(dp[k][n] != -1)
            return dp[k][n];
        
        int totalMoves = n; // or we can assign Integer.MAX_VALUE
        
        int low = 1, high = n;
        while(low <= high)
        {
            int mid = (low + high) / 2;
            
            int eggBreak = solve(k - 1, mid - 1, dp);
            int dontBreak = solve(k, n - mid, dp);
            
            int currentMoves = 1 + Math.max(eggBreak, dontBreak);
            totalMoves = Math.min(totalMoves, currentMoves);
            if(eggBreak == dontBreak)
                break;
            else if(eggBreak > dontBreak)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return dp[k][n] = totalMoves;
    }
}