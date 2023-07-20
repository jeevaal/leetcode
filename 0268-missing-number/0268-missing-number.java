import java.util.*;
class Solution {
    public int missingNumber(int[] nums) {
        List<Integer> l1 = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            l1.add(nums[i]);
        
        for(int i=0;i<=l1.size();i++)
        {
            if(!l1.contains(i))
                 return i;
        }
        return 0;
    }
}