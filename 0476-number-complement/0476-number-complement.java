class Solution {
    public int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        String temp = "";
        for(char c : bin.toCharArray())
        {
            temp += (c == '0')?"1":"0";
        }
        return Integer.parseInt(temp, 2);
    }
}