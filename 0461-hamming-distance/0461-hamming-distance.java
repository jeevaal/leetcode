class Solution {
    public int hammingDistance(int x, int y) {
        String X = Integer.toBinaryString(x);
        String Y = Integer.toBinaryString(y);

        while(X.length() < Y.length())
            X = "0" + X;
        while(Y.length() < X.length())
            Y = "0" + Y;

        int count = 0;
        for(int i = 0; i < X.length(); i++)
        {
            if(((X.charAt(i) - '0') ^ (Y.charAt(i) - '0')) == 1)
                count++;
        }
        return count;
    }
}