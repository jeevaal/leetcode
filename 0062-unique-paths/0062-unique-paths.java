class Solution {
    public int uniquePaths(int m, int n) {
        int N = n + m - 2;
        int R = m - 1; // or n - 1
        
        return ncr(N, R);
    }
    
    public int ncr(int n, int r)
    {
        double res = 1;
        for(int i = 1; i <= r; i++)
        {
            res = res * (n - i + 1);
            res = res / (i);
        }
        return (int)Math.round(res);
    }
}