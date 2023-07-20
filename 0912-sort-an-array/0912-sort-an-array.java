class Solution {
    public int[] sortArray(int[] nums) {
        int low = 0, high = nums.length - 1;
        mergeSort(nums, low, high);
        return nums;
    }
    
    void mergeSort(int nums[], int low, int high)
    {
        if(low == high)
            return;
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }
    
    void merge(int nums[], int low, int mid, int high)
    {
        int temp[] = new int[high + 1];
        int left = low, right = mid + 1, k = 0;
        while(left <= mid && right <= high)
        {
            if(nums[left] > nums[right])
                temp[k++] = nums[right++];
            else
                temp[k++] = nums[left++];
        }
        while(left <= mid)
            temp[k++] = nums[left++];
        while(right <= high)
            temp[k++] = nums[right++];
        
        for(int i = 0; i < k; i++)
            nums[low + i] = temp[i];
    }
}