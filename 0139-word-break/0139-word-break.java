class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(0, s, wordDict, dp);
    }
    
    public boolean solve(int index, String s, List<String> wordDict, int dp[])
    {
        if(index >= s.length())
            return true;
        
        if(dp[index] != -1)
            return (dp[index] == 1) ? true : false;
        
        for(int i = index; i < s.length(); i++)
        {
            String temp = s.substring(index, i + 1);
            if(wordDict.contains(temp) && solve(i + 1, s, wordDict, dp))
            {
                dp[index] = 1;
                return true;
            }
                
        }
        dp[index] = 0;
        return false;
    }
}