class Solution {
    public int minAddToMakeValid(String s) {
        // Stack<Character> st = new Stack<>();
        // for(char c : s.toCharArray())
        // {
        //     if(c == '(')
        //         st.push(c);
        //     else
        //     {
        //         if(!st.isEmpty() && st.peek() == '(')
        //             st.pop();
        //         else
        //             st.push(c);
        //     }
        // }
        // return st.size();
        
        // since it is only one type of bracket, we can use variables
        
        int st = 0, close = 0;
        for(char c : s.toCharArray())
        {
            if(c == '(')
                st++;
            else
            {
                if(st != 0)
                    st--;
                else
                    close++;
            }
        }
        
        return st + close;
        
    }
}