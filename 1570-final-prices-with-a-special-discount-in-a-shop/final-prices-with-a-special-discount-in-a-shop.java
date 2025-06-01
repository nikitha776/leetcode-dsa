class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i >= 0;i--) {
            while(!st.isEmpty() && st.peek() > prices[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? prices[i] : prices[i]-st.peek();
            st.push(prices[i]);
        }
        return res;
    }
}