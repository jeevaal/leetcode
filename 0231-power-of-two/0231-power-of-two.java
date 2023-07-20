//import java.text.DecimalFormat;
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        return (Math.log10(n)/Math.log10(2))%1==0;
    }
}