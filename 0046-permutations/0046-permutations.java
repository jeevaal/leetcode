class Solution {
    public void permutation(int index, int nums[], List<List<Integer>> res)
    {
        if(index == nums.length)
        {
            List<Integer> l = new ArrayList<>();
            for(int i =0; i < nums.length; i++)
                l.add(nums[i]);
            res.add(l);
            return;
        }
        
        for(int i = index; i < nums.length; i++)
        {
            swap(index, i, nums);
            permutation(index + 1, nums, res);
            swap(index, i, nums);
        }
    }
    
    public void swap(int i, int j, int nums[])
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutation(0, nums, res);
        return res;
    }
}