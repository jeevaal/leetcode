class Solution {
    public boolean isPalindrome(int x) {
        int n=x;
        if(x<0 || (x%10==0 && x!=0)){
            return false;
        }
        
        int rev=0;
        while(x>0)
        {
            int rem=x%10;
            rev=rev*10+rem;
            x/=10;
        }
        if(n==rev)
            return true;
        else
            return false;
    }
}