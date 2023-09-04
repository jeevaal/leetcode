class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int ele : asteroids)
        {
            boolean flag = true;
            while(!st.isEmpty() && st.peek() > 0 && ele < 0)
            {
                if(Math.abs(st.peek()) < Math.abs(ele))
                {
                    st.pop();
                    continue;
                }
                else if(Math.abs(st.peek()) == Math.abs(ele))
                    st.pop();
                
                flag = false;
                break;
            }
            if(flag)
                st.push(ele);
        }
        
        int res[] = new int[st.size()];
        for(int i = st.size() - 1; i >= 0; i--)
            res[i] = st.pop();
        
        return res;
    }
}