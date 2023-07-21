class Solution {
    public String convertToBase7(int num) {
        if( num == 0)
            return "0";
        String res = "";
        int flag = 0;
        if( num < 0 )
        {
            flag = 1;
            num = Math.abs(num);
        }
        while( num > 0 )
        {
            int rem = num % 7;
            res = rem + res;
            num /= 7;
        }
        if( flag == 1)
            return "-" + res;
        return res;
    }
}