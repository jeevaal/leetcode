class Solution {
    public int arrayPairSum(int[] nums) {
        int sum = 0, n = nums.length;
        Arrays.sort(nums);
        for( int i = 0; i < n - 1; i += 2 )
            sum += nums[i];
        return sum;
    }
}