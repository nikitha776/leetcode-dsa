class Solution {
    int[] findNse(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i >= 0;i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }
    int[] findPsee(int[] arr) {
        int  n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i < n;i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }
    public int sumSubarrayMins(int[] arr) {
        int[] nse = findNse(arr);
        int[] psee = findPsee(arr);
        int n = arr.length;
        int mod = (int)(1e9+7);
        long total = 0;
        for(int i = 0;i < n;i++) {
            long left = i - psee[i];
            long right = nse[i] - i;
            long val = ((left%mod)*(right%mod)*(arr[i]%mod))%mod;
            total = (total + val)%mod;
        }
        return (int)total;
    }
}