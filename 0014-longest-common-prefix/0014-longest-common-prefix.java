class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s="";
        int min=Integer.MAX_VALUE,flag=0;
        
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
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++)
            {
                if(c!=strs[j].charAt(i))
                    return s;
            }
            s+=c;
        }
        return s;
    }
}