class Solution {
    public int minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();
        int dp[][] = new int[i][j];
        for(int row[] : dp)
            Arrays.fill(row, - 1);
        return editDistance(i - 1, j - 1, word1, word2, dp);
    }
    
    public int editDistance(int i, int j, String s1, String s2, int dp[][])
    {
        // base case
        if(i < 0)
            return j + 1; // insert remaining characters
        if(j < 0)
            return i + 1; // delete remaining characters
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        //match
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 0 + editDistance(i - 1, j -1, s1, s2, dp);
        // no match
        // delete: i - 1, j
        // insert: i, j - 1
        // replace: i - 1, j - 1
        
        return dp[i][j] = 1 + Math.min(editDistance(i - 1, j, s1, s2, dp), Math.min(editDistance(i, j - 1, s1, s2, dp), editDistance(i - 1, j - 1, s1, s2, dp)));
    }
}