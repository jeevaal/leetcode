class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
        {
            s.add(nums[i]);
        }
        
        for(int ele : s)
        {
            if(!s.contains(ele - 1))
            {
                int count = 1;
                int x = ele;
                while(s.contains(x + 1))
                {
                    x++;
                    count++;
                }
                
                max = Math.max(max, count);
            }
        }
        return max;
    }
}