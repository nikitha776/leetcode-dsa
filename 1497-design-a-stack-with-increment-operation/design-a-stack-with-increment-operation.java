class CustomStack {
    int[] stack;
    int top = -1;
    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
    }
    
    public void push(int x) {
        if(top < this.stack.length-1) {
            this.stack[++top] = x;
        }
    }
    
    public int pop() {
        if(top == -1) return -1;
        return stack[top--];
    }
    
    public void increment(int k, int val) {
        for(int i = 0;i < Math.min(k,this.stack.length);i++) {
            this.stack[i] = stack[i] + val; 
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */