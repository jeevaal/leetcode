class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> l1 = new HashSet<>();
        HashSet<Integer> l2 = new HashSet<>();

        for(int i=0;i<nums1.length;i++)
            l1.add(nums1[i]);
        for(int i=0;i<nums2.length;i++)
            l2.add(nums2[i]);

        l1.retainAll(l2);

        int count=0;
        int arr[]=new int[l1.size()];
        for(int x:l1)
            arr[count++]=x;
        return arr;
    }
}