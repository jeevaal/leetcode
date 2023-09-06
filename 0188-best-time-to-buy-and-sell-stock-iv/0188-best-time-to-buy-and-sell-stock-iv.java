class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length][2][k + 1];
        for(int row1[][] : dp)
            for(int row2[] : row1)
                Arrays.fill(row2, -1);
        return solve(0, 1, k, prices.length, prices, dp);
    }
    
    public int solve(int index, int buy, int k, int n, int prices[], int dp[][][])
    {
        // base case
        if(index == n || k == 0)
            return 0;
        
        if(dp[index][buy][k] != -1)
            return dp[index][buy][k];
        
        int profit = 0;
        if(buy == 1)
        {
            int Buy = -prices[index] + solve(index + 1, 0, k, n, prices, dp);
            int notBuy = 0 + solve(index + 1, 1, k, n, prices, dp);
            profit = Math.max(Buy, notBuy);
        }
        else
        {
            int sell = prices[index] + solve(index + 1, 1, k - 1, n, prices, dp);
            int notSell = 0 + solve(index + 1, 0, k, n, prices, dp);
            profit = Math.max(sell, notSell);
        }
        
        return dp[index][buy][k] = profit;
    }
}