class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length];
        for( int i = 0; i < nums1.length; i++ )
        {
            int index = 0;
            while( nums2[index] != nums1[i] )
                index++;
            int element = -1;
            index++;
            while( index < nums2.length )
            {
                if( nums2[index] > nums1[i] )
                {
                    element = nums2[index];
                    break;
                }
                index++;
            }
            res[i] = element;
        }
        return res;
    }
}