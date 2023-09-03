class StockSpanner {

    Stack<List<Integer>> st;
    
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        
        int count = 1;
        
        while(!st.isEmpty() && st.peek().get(0) <= price)
            count += st.pop().get(1);
        
        List<Integer> temp = new ArrayList<>();
        temp.add(price);
        temp.add(count);
        st.push(temp);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */