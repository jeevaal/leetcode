class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount + 1];
        for(int row[] : dp)
            Arrays.fill(row, -1);
        int result = solve(coins.length - 1, amount, coins, dp);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
    
    public int solve(int index, int amount, int coins[], int dp[][]) {
        if (amount == 0) 
            return 0;
        if (index < 0 || amount < 0)
            return Integer.MAX_VALUE;
        
        if(dp[index][amount] != -1)
            return dp[index][amount];
        
        int notTake = solve(index - 1, amount, coins, dp);
        
        int take = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            int remaining = solve(index, amount - coins[index], coins, dp);
            if (remaining != Integer.MAX_VALUE) {
                take = 1 + remaining;
            }
        }
        
        return dp[index][amount] = Math.min(take, notTake);
    }
}
