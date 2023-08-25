class Solution {
    public String countAndSay(int n) {
        String initial = "1";
        for(int i = 1; i < n; i++)
        {
            initial = build(initial);
        }
        return initial;
    }
    
    public String build(String num)
    {
        int count = 1;
        String temp = "";
        char curr = num.charAt(0);
        int n = num.length();
        for(int i = 1; i < n; i++)
        {
            if(curr == num.charAt(i))
                count++;
            else
            {
                temp += count;
                temp += curr;
                count = 1;
                curr = num.charAt(i);
            }
        }
        temp += count;
        temp += curr;
        return temp;
    }
    
}