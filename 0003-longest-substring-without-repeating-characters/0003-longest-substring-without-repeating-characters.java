class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while(right < n)
        {
            char c = s.charAt(right);
            if(hm.containsKey(c))
                left = Math.max(hm.get(c) + 1, left);
            
            hm.put(c, right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}