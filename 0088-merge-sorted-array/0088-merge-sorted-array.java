class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = nums1.length-1;

        while(j>=0)
        {
            if(i>=0 && nums1[i]>nums2[j])
            {
                nums1[k]=nums1[i];
                k--;
                i--;
            }
            else
            {
                nums1[k]=nums2[j];
                k--;
                j--;
            }
        }
        
        // Normal merge two sorted array with extra space
        // int i = 0, j = 0, k = 0;
        // int res[] = int[m + n];
        // while(i < m && j < n)
        // {
        //     if(nums1[i] < nums2[j])
        //         res[k++] = nums1[i++];
        //     else
        //         res[k++] = nums2[j++];
        // }
        // while(i < m)
        //     res[k++] = nums1[i++];
        // while(j < n)
        //     res[k++] = nums2[j++];
        
        
        // Normal merge without extra space i.e they are separated but sorted
        // int i = m - 1;
        // int j = 0;
        // while(i >= 0 && j < n)
        // {
        //     if(nums1[i] > nums2[j])
        //     {
        //         int temp = nums2[j];
        //         nums2[j] = nums1[i];
        //         nums1[i] = temp;
        //     }
        //     else
        //         break;
        // }
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
    }
}