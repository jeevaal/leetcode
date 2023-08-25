class Solution {
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        
        // using kmp algorithm
        //haystack => text, needle => pattern
        int m = needle.length();
        int n = haystack.length();
        
        int lps[] = new int[m];
        computeLPS(lps, needle, m);
        
        int i = 0, j = 0;// i - text, j - pattern
        while((n - i) >= (m - j))
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
            }
            
            if(j == m)
            {
                return i - j;//onlu for this question
                
                // System.out.println(i - j);
                // j = lps[j - 1];
            }
            else if(i < n && haystack.charAt(i) != needle.charAt(j))
            {
                if(j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        
        return -1;
    }
    
    void computeLPS(int lps[], String pattern, int m)
    {
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while(i < m)
        {
            if(pattern.charAt(i) == pattern.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if(len != 0)
                    len = lps[len - 1];
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}