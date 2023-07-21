class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0)
            return 1;
        int sum = 0, bit = 0;
        while(n > 0)
        {
            if((n & 1) == 0)
                sum += (int)Math.pow(2,bit);
            n >>= 1;
            bit++;
        }
        return sum;
    }
}