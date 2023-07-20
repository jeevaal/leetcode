import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st =new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            try{
            char ch=s.charAt(i);
            switch(ch)
            {
                case '(':
                    st.push(')');
                    break;
                case '[':
                    st.push(']');
                    break;
                case '{':
                    st.push('}');
                    break;
                case ')':
                    if(st.pop()!=ch)
                        return false;
                    break;
                case ']':
                    if(st.pop()!=ch)
                        return false;
                    break;
                case '}':
                    if(st.pop()!=ch)
                        return false;
                    break;
            }
        }
        catch(EmptyStackException e)
        {
            return false;
        }
        }
        if(st.size()==0)
            return true;
        return false;
    }
}