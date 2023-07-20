class Solution {
    public int[] countBits(int n) {
        int arr[] = new int[n+1];
        for(int i=0; i<n+1; i++)
            arr[i]=Integer.bitCount(i);
        
        return arr;

    // int[] f = new int[num + 1];
    // for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
    // return f;
    }
}