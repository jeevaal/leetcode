class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1)
            return nums[0];
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(nums[i]))
                hm.replace(nums[i],hm.get(nums[i])+1);
            else
                hm.put(nums[i],1);
        }
        for(Map.Entry<Integer,Integer> entry : hm.entrySet())
        {
            if(entry.getValue()==1)
                return  entry.getKey();
        }
        return 0;
    }
}