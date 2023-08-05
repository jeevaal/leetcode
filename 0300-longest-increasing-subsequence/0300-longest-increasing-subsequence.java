class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > temp.get(temp.size() - 1))
            {
                temp.add(nums[i]);
            }
            else
            {
                int index = binarySearch(temp, nums[i]);
                temp.set(index, nums[i]);
            }
        }
        return temp.size();
    }
    
    public int binarySearch(List<Integer> temp, int target)
    {
        int low = 0;
        int high = temp.size() - 1;
        
        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(temp.get(mid) == target)
                return mid;
            else if(temp.get(mid) < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return low;
    }
}