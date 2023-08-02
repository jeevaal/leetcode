class Solution {
    public int majorityElement(int[] nums) {
        //better approach
        // HashMap<Integer,Integer> hm = new HashMap<>();
        // for(int i=0;i<nums.length;i++)
        // {
        //     if(hm.containsKey(nums[i]))
        //         hm.replace(nums[i],hm.get(nums[i])+1);
        //     else
        //         hm.put(nums[i],1);
        //     if(hm.get(nums[i])>nums.length/2)
        //         return nums[i];
        // }
        // return 0;
        
        //optimal approach
        //moore's voting algorithm
        
        int count = 0, n = nums.length;
        int ele = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++)
        {
            if(count == 0)
            {
                count++;
                ele = nums[i];
            }
            else if(ele != nums[i])
            {
                count--;
            }
            else
            {
                count++;
            }
        }
        
        count = 0;
        
        for(int i = 0; i < n; i++)
        {
            if(nums[i] == ele)
                count++;
            if(count > n / 2)
                return ele;
        }
        return 0;
    }
}