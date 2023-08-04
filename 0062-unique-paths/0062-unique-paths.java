class Solution {
        //using combination
//     public int uniquePaths(int m, int n) {
//         int N = n + m - 2;
//         int R = m - 1; // or n - 1
        
//         return ncr(N, R);
//     }
    
//     public int ncr(int n, int r)
//     {
//         double res = 1;
//         for(int i = 0; i < r; i++)
//         {
//             res = res * (n - i);
//             res = res / (i + 1);
//         }
//         return (int)Math.round(res);
//     }
    
    // using dp
    public int uniquePaths(int m, int n) {
        
        int dp[][] = new int[m][n];
        for(int row[] : dp)
            Arrays.fill(row, -1);
        int count = countPaths(0, 0, m, n, dp);
        return count;
        
    }
    
    public int countPaths(int i, int j, int m, int n, int dp[][])
    {
        if(i == m - 1 && j == n - 1)
            return 1;
        
        if(i >= m || j >= n)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        return dp[i][j] = countPaths(i + 1, j, m, n, dp) + countPaths(i, j + 1, m, n, dp);
    }
}