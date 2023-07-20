class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0)
            return false;
        return (Math.log10(n)/Math.log10(3))%1==0;

        // if(n<=0)
        //     return false;
        // if(n%3==0)
        //     return isPowerOfThree(n/3);
        // if(n==1)
        //     return true;
        // return false;
    }
}