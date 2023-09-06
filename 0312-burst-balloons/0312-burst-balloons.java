class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for(int row[] : dp)
            Arrays.fill(row, -1);
        return solve(0, n - 1, nums, dp);
    }
    
    public int solve(int i, int j, int nums[], int dp[][])
    {
        // base case
        if(i > j)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int maxCost = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++)
        {
            int cost = (((i <= 0) ? 1 : nums[i - 1]) * nums[k] * ((j >= nums.length - 1) ? 1 : nums[j + 1])) + solve(i, k - 1, nums, dp) + solve(k + 1, j, nums, dp);
            // instead of using this complex way, add 1 in front and last to the original array, so that it would be easy to code
            // int cost = nums[i - 1] * nums[k] * nums[j + 1] + solve(i, k - 1, nums) + solve(k + 1, j, nums);
            maxCost = Math.max(maxCost, cost);
            
        }
        return dp[i][j] = maxCost;
    }
    
    
}