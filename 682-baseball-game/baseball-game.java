class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i < operations.length;i++) {
            if(operations[i].equals("C")) {
                st.pop();
            } else if(operations[i].equals("D")) {
                st.push(st.peek()*2);
            } else if(operations[i].equals("+")) {
                int n1 = st.pop();
                int n2 = st.pop();
                int n3 = n1 + n2;
                st.push(n2);
                st.push(n1);
                st.push(n3);
            } else {
                st.push(Integer.parseInt(operations[i]));
            }
        }
        int ans  = 0;
        while(!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}