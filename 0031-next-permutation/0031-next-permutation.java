class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, index = -1;
        for(int i = n - 2; i >= 0; i--)
        {
            if(nums[i] < nums[i + 1])
            {
                index = i;
                break;
            }
        }
        
        if(index == -1)
        {
            Arrays.sort(nums);
            return;
        }
        
        for(int i = n - 1; i > index; i--)
        {
            if(nums[i] > nums[index])
            {
                //swap
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        
        //Arrays.sort(nums, index + 1, n);
        // reverse the array from index + 1 to n
        int start = index + 1, end = n - 1;
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}