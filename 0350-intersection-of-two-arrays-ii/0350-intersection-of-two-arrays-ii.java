class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]==nums2[j])
            {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j])
                i++;
            else
                j++;
        }

        int arr[] = new int[list.size()];
        for(int k=0;k<list.size();k++)
            arr[k]=list.get(k);
        return arr;

        // List<Integer> l1 = new ArrayList<>();
        // List<Integer> l2 = new ArrayList<>();
        // int count=0;

        // for(int i=0;i<nums1.length;i++)
        // {
        //     l1.add(nums1[i]);
        // }
        // for(int i=0;i<nums2.length;i++)
        // {
        //     l2.add(nums2[i]);
        // }

        // int small=(l1.size()<l2.size())?1:2;
        // int arr[];

        // if(small==1)
        // {
        //     arr= new int[l1.size()];
        //     Iterator k = l1.iterator();
        //     while(k.hasNext())
        //     {
        //         int temp=(int)k.next();
        //         if(l2.contains(temp))
        //         {
        //             arr[count++]=temp;
        //             k.remove();
        //             l2.remove(Integer.valueOf(temp));
        //         }
        //     }
        // }
        // else
        // {
        //     arr= new int[l2.size()];
        //     Iterator k = l2.iterator();
        //     while(k.hasNext())
        //     {
        //         int temp=(int)k.next();
        //         if(l1.contains(temp))
        //         {
        //             arr[count++]=temp;
        //             System.out.println(arr[0]);
        //             k.remove();
        //             l1.remove(Integer.valueOf(temp));
        //         }
        //     }
        // }
        // int res[] = new int[count];
        // for(int i=0;i<count;i++)
        //     res[i]=arr[i];
        // return res;
    }
}