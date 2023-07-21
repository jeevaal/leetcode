class Solution {
    public int findLHS(int[] nums) {
        TreeMap< Integer, Integer > tm = new TreeMap<>();
        int size = 0;
        for( int i : nums )
        {
            if( tm.containsKey(i) )
                tm.replace(i, tm.get(i) + 1);
            else
                tm.put(i, 1);
        }
        Arrays.sort(nums);
        for( int i = 0; i < nums.length - 1; i++ )
        {
            if( nums[i + 1] - nums[i] == 1 )
            {
                int temp = tm.get( nums[i] ) + tm.get( nums[i + 1] );
                if( size < temp )
                    size = temp;
            }
        }
        return size;
    }
}