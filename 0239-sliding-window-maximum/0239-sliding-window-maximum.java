class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        int res[] = new int[n - k + 1];
        for(int i = 0; i < n; i++)
        {
            // removing out of bound elements
            while(!q.isEmpty() && q.peek() == i - k)
                q.poll();
            
            // removing useless data
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();
            
            q.add(i);
            if(i >= k - 1)
                res[i - k + 1] = nums[q.peek()];
        }
        return res;
    }
}