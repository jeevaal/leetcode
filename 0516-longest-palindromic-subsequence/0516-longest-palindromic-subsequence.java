class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int row[] : dp)
            Arrays.fill(row, -1);
        String rev = "";
        for(int i = n - 1; i >= 0; i--)
            rev += s.charAt(i);
        return lcs(n - 1, n - 1, s, rev, dp);
    }
    
    public int lcs(int i, int j, String a, String b, int dp[][])
    {
        if(i < 0 || j < 0)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // match
        if(a.charAt(i) == b.charAt(j))
            return dp[i][j] = 1 + lcs(i - 1, j - 1, a, b, dp);
        
        // not match
        return dp[i][j] = 0 + Math.max(lcs(i - 1, j, a, b, dp), lcs(i, j - 1, a, b, dp));
    }
}