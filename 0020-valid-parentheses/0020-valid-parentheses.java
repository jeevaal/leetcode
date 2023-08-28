import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st =new Stack<Character>();
        for(char c : s.toCharArray())
        {
            if(c == '[' || c == '{' || c == '(')
                st.push(c);
            else
            {
                if(st.isEmpty())
                    return false;
                char temp = st.pop();
                if((c == ']' && temp == '[') || (c == '}' && temp == '{') || (c == ')' && temp == '('))
                    continue;
                else
                    return false;
            }
        }
        return st.isEmpty();
    }
}