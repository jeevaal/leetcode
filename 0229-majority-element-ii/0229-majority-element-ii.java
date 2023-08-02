class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        int n = nums.length;
        
        for(int i = 0; i < n; i++)
        {
            if(count1 == 0 && nums[i] != ele2)
            {
                count1++;
                ele1 = nums[i];
            }
            else if(count2 == 0  && nums[i] != ele1)
            {
                count2++;
                ele2  = nums[i];
            }
            else if(nums[i] == ele1)
                count1++;
            else if(nums[i] == ele2)
                count2++;
            else
            {
                count1--;
                count2--;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        count1 = count2 = 0;
        for(int i = 0; i < n; i++)
        {
            if(nums[i] == ele1)
                count1++;
            else if(nums[i] == ele2)
                count2++;
        }
        
        int minimumToHave = n / 3 + 1;
        if(count1 >= minimumToHave)
            res.add(ele1);
        if(count2 >= minimumToHave)
            res.add(ele2);
        
        return res;
    }
}