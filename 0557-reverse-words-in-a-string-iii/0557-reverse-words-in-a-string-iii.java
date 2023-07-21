class Solution {
    public String reverseWords(String s) {
        String arr[] = s.split(" ");
        String res = "";
        for( int i = 0; i < arr.length; i++ )
        {
            StringBuilder sb = new StringBuilder(arr[i]);
            sb.reverse();
            if( i != 0 )
                res += " ";
            res += sb; 
        }
        return res;
    }
}