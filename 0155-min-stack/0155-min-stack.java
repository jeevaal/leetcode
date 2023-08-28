class MinStack {
    Stack<Long> s = new Stack<>();
    long min;
    public MinStack() {
        min = Long.MAX_VALUE;
    }
    
    public void push(int value) {
        Long val = (long)value;
        if(s.isEmpty())
        {
            s.push(val);
            min = val;
            return;
        }
        if(val < min)
        {
            s.push(2 * val - min);
            min = val;
        }
        else
            s.push(val);
    }
    
    public void pop() {
        Long val = s.pop();
        if(val < min)
            min = 2 * min - val;
    }
    
    public int top() {
        if(s.isEmpty())
            return -1;
        long ele = s.peek();
        if(ele < min)
            return (int)min;
        return (int)ele;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */