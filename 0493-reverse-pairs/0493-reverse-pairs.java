class Solution {
    public int reversePairs(int[] nums) {
        int res = mergeSort(nums, 0, nums.length - 1);
        return res;
    }
    
    public int mergeSort(int nums[], int low, int high)
    {
        int count = 0;
        if(low >= high)
            return count;
        
        int mid = (low + high) / 2;
        
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }
    
    public void merge(int nums[], int low, int mid, int high)
    {
        ArrayList<Integer> al = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        
        while(left <= mid && right <= high)
        {
            if(nums[left] <= nums[right])
            {
                al.add(nums[left]);
                left++;
            }
            else
            {
                al.add(nums[right]);
                right++;
            }
        }
        
        while(left <= mid)
        {
            al.add(nums[left]);
            left++;
        }
        
        while(right <= high)
        {
            al.add(nums[right]);
            right++;
        }
        
        for(int i = low; i <= high; i++)
            nums[i] = al.get(i - low);
    }
    
    public int countPairs(int nums[], int low, int mid, int high)
    {
        int count = 0;
        int right = mid + 1;
        for(int i = low; i <= mid; i++)
        {
            while(right <= high && nums[i] > 2 * (long)nums[right])// this change is due to overflw, when input is very big number doubling them leads to overflow
                right++;
            
            count += (right - (mid + 1));
        }
        return count;
    }
    
}