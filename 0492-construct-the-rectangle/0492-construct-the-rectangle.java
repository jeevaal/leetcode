class Solution {
    public int[] constructRectangle(int area) {
        int res[] = new int[2];
        int W = (int)Math.sqrt(area);
        int L = 0;
        while(W > 0)
        {
            L = area / W;
            if(L * W == area)
            {
                res[0] = L;
                res[1] = W;
                return res;
            }
            W--;
        }
        return res;
    }
}