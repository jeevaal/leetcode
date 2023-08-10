class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++)
        {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;
            
            while(j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0)
                    j++;
                else if(sum > 0)
                    k--;
                else
                {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    
                    res.add(l);
                    j++;
                    k--;
                    
                    while(j < k && nums[j] == nums[j - 1])
                        j++;
                    while(j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return res;
    }
}