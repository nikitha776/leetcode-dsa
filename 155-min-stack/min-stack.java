class MinStack {

    private Stack<Long> st;
    private long min;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        long value = (long)val;
        if(st.isEmpty()) {
            st.push(value);
            min = value;
        } else {
            if(val < min) {
                st.push((2*value)-min);
                min = value;
            } else {
                st.push(value);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        if(st.peek() < min) {
            min = 2*min - st.peek();
        }
        st.pop();
    }
    
    public int top() {
        long top = st.peek();
        if(st.peek() < min) {
            return (int)min;
        }
        return (int)top;
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