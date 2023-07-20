class Solution {
    public boolean isPalindrome(String s) {
        String temp="";
        for(int i=0;i<s.length();i++)
        {
            if(isalphanumeric(s.charAt(i)))
                temp+=s.charAt(i);
        }
        temp=temp.toLowerCase();
        int n=temp.length();
        for(int i=0;i<n/2;i++)
        {
            if(temp.charAt(i)!=temp.charAt(n-i-1))
                return false;
        }
        return true;
    }

    public boolean isalphanumeric(char c)
    {
        int t=c;
        if((t>=48 && t<=57) || (t>=65 && t<=90) || (t>=97 && t<=122))
            return true;
        return false;
    }
}