class Solution {
    public int repeatedStringMatch(String a, String b) {
        if(a.equals(b))
            return 1;
        
        int count = 1;
        String temp = a;
        while(temp.length() < b.length())
        {
            temp += a;
            count++;
        }
        if(rabinKarp(temp, b) != -1)
            return count;
        if(rabinKarp(temp + a, b) != -1)
            return count + 1;
        
        return -1;
        
    }
    
    public int rabinKarp(String text, String pattern)
    {
        int n = text.length();
        int m = pattern.length();
        
        int d = 26;// no. of input characters
        int pHash = 0;
        int tHash = 0;
        int q = 27; // a prime number
        int h = 1;
        
        for(int i = 0; i < m - 1; i++)
            h = (h * d) % q;
        
        for(int i = 0; i < m; i++)
        {
            pHash = (d * pHash + pattern.charAt(i)) % q;
            tHash = (d * tHash + text.charAt(i)) % q;
        }
        
        for(int i = 0; i <= n - m; i++)
        {
            if(pHash == tHash)
            {
                int j = 0;
                for(j = 0; j < m; j++)
                {
                    if(text.charAt(i + j) != pattern.charAt(j))
                        break;
                }
                
                if(j == m)
                    return i; // in this program just the furst occurence is enough, if we need all just print it instead of returning it
            }
            
            if(i < n - m)
            {
                tHash = (d * (tHash - text.charAt(i) * h) + text.charAt(i + m)) % q;
            
                if(tHash < 0)
                    tHash = tHash + q;
            }
        }
        return -1;
    }
}