class Solution {
    public int[] findErrorNums(int[] nums) {
        int res[] = new int[2];
        TreeSet< Integer > hs = new TreeSet<>();
        for( int i = 0; i < nums.length; i++ )
        {
            if( hs.contains( nums[i] ) )
                res[0] = nums[i];
            else
                hs.add(nums[i]);
        }
        for( int i = 1; i <= nums.length; i++ )
            if( !hs.contains(i) )
            {
                res[1] = i;
                break;
            }
        
        return res;
    }
}