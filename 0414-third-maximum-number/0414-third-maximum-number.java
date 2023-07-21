class Solution {
    public int thirdMax(int[] nums) {
        long firstMax, secondMax, thirdMax;
        firstMax = secondMax = thirdMax = Long.MIN_VALUE;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > firstMax)
            {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            }
            else if(nums[i] < firstMax && nums[i] > secondMax)
            {
                thirdMax = secondMax;
                secondMax = nums[i];
            }
            else if(nums[i] < firstMax && nums[i] < secondMax && nums[i] > thirdMax)
                thirdMax = nums[i];
            
            
        }
        if(thirdMax == Long.MIN_VALUE || thirdMax == secondMax)
            return (int)firstMax;
        return (int)thirdMax;

        // TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
        // for(int i = 0; i < nums.length; i++)
        //     ts.add(nums[i]);
        // int i=0;
        // int nums2[] = new int[ts.size()];
        // for(int e : ts)
        //     nums2[i++] = e;
        
        // if(nums2.length < 3)
        //     return nums2[0];
        // return nums2[2];
    }
}