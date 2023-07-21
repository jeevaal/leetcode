class Solution {
    public int arrangeCoins(int n) {
        int i = 0;
        while(i < n)
        {
            i++;
            n = n - i;
        }
        return i;
    }
}