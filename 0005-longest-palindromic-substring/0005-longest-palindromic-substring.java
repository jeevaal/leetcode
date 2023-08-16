class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;
        int len = 0, maxLen = 0;
        
        for(int i = 0; i < n; i++)
            {
                int left = i, right = i + 1;
                while(left >= 0 && right < n)
                {
                    if(s.charAt(left) == s.charAt(right))
                    {
                        left--;
                        right++;
                    }
                    else
                        break;
                }
                len = right - left - 1;
                if(len > maxLen)
                {
                    maxLen = len;
                    start = left + 1;
                    end = right - 1;
                }
            }
        for(int i = 0; i < n; i++)
            {
                int left = i, right = i;
                while(left >= 0 && right < n)
                {
                    if(s.charAt(left) == s.charAt(right))
                    {
                        left--;
                        right++;
                    }
                    else
                        break;
                }
                len = right - left - 1;
                if(len > maxLen)
                {
                    maxLen = len;
                    start = left + 1;
                    end = right - 1;
                }
            }
        
        return s.substring(start, end + 1);
        
    }
}