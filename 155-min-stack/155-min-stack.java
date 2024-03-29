class MinStack {

    Stack<Long> st;
    int currMin;
    long prevMin;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()) {
            st.push(1L*val);
            currMin = val;
        } else {
            if(val > currMin) {
                st.push(1L*val);
            } else {
                // val to push on stack - 2*x - currMin < x
                st.push(((1L*val) << 1L) - 1L*currMin);
                prevMin = currMin;
                currMin = val;
            }
            
        }
    }
    
    public void pop() {
        if(!st.isEmpty()) {
            if(st.peek() > currMin) {
                st.pop();
            } else {
                 // prevMin = 2*currMin - st.top()
                currMin = (int) (1L * (currMin << 1) - st.peek());
                st.pop();
            }
        }
    }
    
    public int top() {
        if(st.peek() > 1L*currMin) return st.peek().intValue();
    
        // compute prev min
        long prevMin = ((1L*currMin) << 1L) - st.peek();
        return (int) ((st.peek()+prevMin) >> 1L);
    }
    
    public int getMin() {
        return currMin;
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