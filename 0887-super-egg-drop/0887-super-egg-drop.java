class Solution {
    public int superEggDrop(int k, int n) {
        Map<String, Integer> memo = new HashMap<>();
        return drop(k, n, memo);
    }
    
    private int drop(int k, int n, Map<String, Integer> memo) {
        // Base cases
        if (k == 1) {
            return n; // With only one egg, you need to drop it from each floor one by one.
        }
        if (n == 0) {
            return 0; // With zero floors, you don't need any moves.
        }

        // Check if the result for the current (k, n) pair is already memoized.
        String key = k + "," + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int minMoves = Integer.MAX_VALUE;

        // Binary search for the optimal drop floor.
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int breaks = drop(k - 1, mid - 1, memo); // Egg breaks, search below mid.
            int doesntBreak = drop(k, n - mid, memo); // Egg doesn't break, search above mid.

            // Take the maximum of these two cases, plus one for the current drop.
            int currentMove = 1 + Math.max(breaks, doesntBreak);

            // Update minMoves with the minimum of all possible drop floors.
            if (breaks > doesntBreak) {
                right = mid - 1;
                minMoves = Math.min(minMoves, currentMove);
            } else {
                left = mid + 1;
                minMoves = Math.min(minMoves, currentMove);
            }
        }

        // Memoize the result for this (k, n) pair.
        memo.put(key, minMoves);

        return minMoves;
        }
}