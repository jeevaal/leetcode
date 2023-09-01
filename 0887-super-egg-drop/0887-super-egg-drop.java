class Solution {
    public int superEggDrop(int k, int n) {
        int[][] memo = new int[k + 1][n + 1];
        return helper(k, n, memo);
    }
    private int helper(int K, int N, int[][] memo) {
        if (N <= 1) {
            return N;
        }
        if (K == 1) {
            return N;
        }
        if (memo[K][N] > 0) {
            return memo[K][N];
        }
        
        int low = 1, high = N, result = N;
        while (low <= high) {
            int mid = (low + high) / 2;
            int left = helper(K - 1, mid - 1, memo);
            int right = helper(K, N - mid, memo);
            result = Math.min(result, Math.max(left, right) + 1);
            if (left < right) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        memo[K][N] = result;
        return result;
    }
    
}