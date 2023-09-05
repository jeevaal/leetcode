class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
         return solve(nums.length - 1, nums, dp);
    }
    
    public int solve(int index, int nums[], int dp[])
    {
        // base case
        if(index < 0)
            return 0;
        if(index == 0)
            return nums[0];
        
        if(dp[index] != -1)
            return dp[index];
        
        // pick
        int pick = nums[index] + solve(index - 2, nums, dp);
        //not pick
        int notPick = solve(index - 1, nums, dp);
        
        return dp[index] = Math.max(pick, notPick);
    }
}