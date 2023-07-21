class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count = 1, maxCount = 0;
        for( int i = 1; i < nums.length; i++ )
        {
            if( nums[i] > nums[i - 1] )
                count++;
            else
            {
                if( count > maxCount )
                    maxCount = count;
                count = 1;
            }
        }
        if( count > maxCount )
            maxCount = count;
        return maxCount;
    }
}