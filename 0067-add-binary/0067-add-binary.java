class Solution {
    public String addBinary(String a, String b) {
        int n,m,carry=0;
        n=a.length();
        m=b.length();
        String c="";
        if(n<m)
        {
            for(int i=0;i<m-n;i++)
            {
                a='0'+a;
            }
        }
        else if(m<n)
        {
            for(int i=0;i<n-m;i++)
            {
                b='0'+b;
            }
        }
        for(int i=a.length()-1;i>=0;i--)
        {
            int temp=(a.charAt(i)-'0')+(b.charAt(i)-'0')+carry;
            if(temp==0)
            {
                c="0"+c;
                carry=0;
            }
            else if(temp==1)
            {
                c="1"+c;
                carry=0;
            }
            else if(temp==2)
            {
                c="0"+c;
                carry=1;
            }
            else
            {
                c="1"+c;
                carry=1;
            }
        }
        if(carry==1)
            c="1"+c;
        return c;
    }
}