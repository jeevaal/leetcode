class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> l = new ArrayList<>();
        if(nums.length==0)
            return l;
        int start=nums[0],end=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]+1==nums[i])
                end=nums[i];
            else
            {
                if(start==end)
                    l.add(String.valueOf(start));
                else
                {
                    String temp="";
                    temp+=String.valueOf(start);
                    temp+="->";
                    temp+=String.valueOf(end);
                    l.add(temp);
                }
                start=nums[i];
                end=nums[i];
            }
        }
        if(start==end)
            l.add(String.valueOf(start));
        else
        {
            String temp="";
            temp+=String.valueOf(start);
            temp+="->";
            temp+=String.valueOf(end);
            l.add(temp);
        }
        return l;
        
    }
}