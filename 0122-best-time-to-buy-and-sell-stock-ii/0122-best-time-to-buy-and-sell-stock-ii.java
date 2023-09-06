class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int row[] : dp)
            Arrays.fill(row, -1);
        return solve(0, 1, prices.length, prices, dp);
    }
    
    public int solve(int index, int buy, int n, int prices[], int dp[][])
    {
        // base case
        if(index == n)
            return 0;
        
        if(dp[index][buy] != -1)
            return dp[index][buy];
        
        int profit = 0;
        if(buy == 1)
        {
            int Buy = -prices[index] + solve(index + 1, 0, n, prices, dp);
            int notBuy = 0 + solve(index + 1, 1, n, prices, dp);
            profit = Math.max(Buy, notBuy);
        }
        else
        {
            int sell = prices[index] + solve(index + 1, 1, n, prices, dp);
            int notSell = 0 + solve(index + 1, 0, n, prices, dp);
            profit = Math.max(sell, notSell);
        }
        
        return dp[index][buy] = profit;
    }
}