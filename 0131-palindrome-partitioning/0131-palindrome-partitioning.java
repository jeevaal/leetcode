class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        palindromePartitioning(0, s, new ArrayList<>(), res);
        return res;
    }
    
    public void palindromePartitioning(int index, String s, List<String> l, List<List<String>> al)
    {
        // base case
        if(index == s.length())
        {
            al.add(new ArrayList<>(l));
            return;
            
        }
        
        for(int i = index; i < s.length(); i++)
        {
            if(isPalindrome(s, index, i))
            {
                l.add(s.substring(index, i + 1));
                palindromePartitioning(i + 1, s, l, al);
                l.remove(l.size() - 1);
            }
        }
        
    }
    
    public boolean isPalindrome(String s, int start, int end)
    {
        while(start < end)
        {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}