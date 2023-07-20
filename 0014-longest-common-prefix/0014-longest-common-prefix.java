class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s="";
        int min=100,flag=0;
        
        if(strs.length==0)
            return s;

        if(strs.length==1){
            s+=strs[0];
            return s;
        }
        
        for(int i=0;i<strs.length;i++)
        {
            if(strs[i].length()<min)
            {
                min=strs[i].length();
            }
        }

        for(int i=0;i<min;i++)
        {
            flag=0;
            for(int j=1;j<strs.length;j++)
            {
                if(strs[0].charAt(i)==strs[j].charAt(i))
                    flag=1;
                else
                    return s;
            }
            if(flag==1)
            s+=strs[0].charAt(i);
        }
        return s;
    }
}