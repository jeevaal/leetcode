class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int row[] : dp)
            Arrays.fill(row, -1);
        return solve(0, 0, m, n, grid, dp);
    }
    
    public int solve(int i, int j, int m, int n, int grid[][], int dp[][])
    {
        // base case
        if(i == m - 1 && j == n - 1)
            return dp[i][j] = grid[i][j];
        
        if(i >= m || j >= n)
            return (int)1e6;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int right = grid[i][j] + solve(i, j + 1, m, n, grid, dp);
        int down = grid[i][j] + solve(i + 1, j, m, n, grid, dp);
        
        return dp[i][j] = Math.min(right, down);
    }
}