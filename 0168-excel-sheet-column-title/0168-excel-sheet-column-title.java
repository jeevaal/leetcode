class Solution {
    public String convertToTitle(int columnNumber) {
        String a="";
        while(columnNumber>0)
        {
            int rem=columnNumber%26;
            if(rem==0)
            {
                a="Z"+a;
                columnNumber=columnNumber/26-1;
            }
            else
            {
                a=(char)('A'+rem-1)+a;
                columnNumber=columnNumber/26;
            }

        }
        return a;
    }
}