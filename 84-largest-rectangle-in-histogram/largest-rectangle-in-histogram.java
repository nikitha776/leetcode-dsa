class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        int maxArea = 0;

        for(int i = 0;i < n;i++) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                nse[st.peek()] = i;
                int area = (nse[st.peek()] - pse[st.peek()] - 1)*heights[st.peek()];
                maxArea = Math.max(area,maxArea);
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        while(!st.isEmpty()) {
            nse[st.peek()] = n;
            int area = (nse[st.peek()] - pse[st.peek()] - 1)*heights[st.peek()];
            maxArea = Math.max(area,maxArea);
            st.pop();
        }
        return maxArea;
    }
}