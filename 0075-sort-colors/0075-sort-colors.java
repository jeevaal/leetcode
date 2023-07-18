class Solution {
    public void sortColors(int[] nums) {
        // counter variable O(2N)
        // Dutch National Flag algorithm O(N)
        // 0 to low-1 = 0, low to mid -1 = 1, mid to high = unsorted, high+1 to n-1 = 2
        //terminating condition when mid goes past high
        int low = 0, mid = 0, high = nums.length - 1;
        while(mid <= high)
        {
            if(nums[mid] == 0)
            {
                swap(low, mid, nums);
                low++;
                mid++;
            }
            else if(nums[mid] == 1)
                mid++;
            else
            {
                swap(mid, high, nums);
                high--;
            }
        }
    }
    
    public void swap(int i, int j, int nums[])
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}