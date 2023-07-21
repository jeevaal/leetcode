class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String res = "";
        int count = 0;
        for(int i = s.length() - 1; i >=0; i--)
        {
            char c = s.charAt(i);
            if(c != '-')
            {
                if(count == k)
                {
                    res = '-' + res;
                    count = 0;
                }
                
                if(c >= 97 && c <= 122)
                    res = String.valueOf(c).toUpperCase() + res;
                else
                    res = c + res;
                count++;
                
            }
                
        }
        return res;
    }
}