class Solution {
    public boolean isPowerOfFour(int n) {
        // if(n<=0)
        //     return false;
        // return (Math.log10(n)/Math.log10(4))%1==0;

        if(n<=0)
            return false;
        if(n%4==0)
            return isPowerOfFour(n/4);
        if(n==1)
            return true;
        return false;
    }
}