class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        for(int i = 0; i <= n; i++)
        {
            while(!st.isEmpty() && (i == n || heights[i] <= heights[st.peek()]))
            {
                int height = heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        return maxArea;
    }
}