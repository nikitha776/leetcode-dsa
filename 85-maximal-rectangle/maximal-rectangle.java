class Solution {
    public int largeHist(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];
        int maxArea = 0;

        for(int i = 0;i < n;i++) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                int x = st.peek();
                nse[x] = i;
                int area = (nse[x]-pse[x]-1)*nums[x];
                maxArea = Math.max(area,maxArea);
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        while(!st.isEmpty()) {
            int x = st.peek();
            nse[x] = n;
            int area = (nse[x]-pse[x]-1)*nums[x];
            maxArea = Math.max(area,maxArea);
            st.pop();
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        int[] heights = new int[m];

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            maxArea = Math.max(maxArea,largeHist(heights));
        }        

        return maxArea;
    }
}