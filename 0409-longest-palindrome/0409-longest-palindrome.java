class Solution {
    public int longestPalindrome(String s) {
        if(s.length() == 1)
            return 1;
        
        int count = 0, flag = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char c : s.toCharArray())
        {
            if(hm.containsKey(c))
                hm.replace(c, hm.get(c)+1);
            else
                hm.put(c, 1);
            
            if(hm.get(c)%2 == 0)
            {
                count += 2;
                hm.replace(c, 0);
            }
        }

        for(Map.Entry<Character,Integer> entry : hm.entrySet())
        {
            if(entry.getValue()%2 != 0)
                return count+1;
                
        }

        return count;
    }
}