class Solution {
    public int[] findNse(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        for(int i = n-1;i >= 0;i--) {
            while(!st.isEmpty() && (nums[st.peek()] >= nums[i])) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
    public int[] findPsee(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] psee = new int[n];
        for(int i = 0;i < n;i++) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }
    public int[] findNgee(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ngee = new int[n];
        for(int i = n-1;i >= 0;i--) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            ngee[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ngee;
    }
    public int[] findPge(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] pge = new int[n];
        for(int i = 0;i < n;i++) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long minTotal = 0L;
        long maxTotal = 0L;
        int[] nse = findNse(nums);
        int[] psee = findPsee(nums);
        int[] ngee = findNgee(nums);
        int[] pge = findPge(nums);
        for(int i = 0;i < n;i++) {
            long left = i - psee[i];
            long right = nse[i] - i;
            minTotal = minTotal + (left*right*nums[i]);
        }
        for(int i = 0;i < n;i++) {
            long left = i - pge[i];
            long right = ngee[i] - i;
            maxTotal = maxTotal + (left*right*nums[i]);
        }
        return maxTotal - minTotal;
        // int n = nums.length;
        // long total = 0;
        // for(int i = 0;i < n;i++) {
        //     int min = nums[i];
        //     int max = nums[i];
        //     for(int j = i;j < n;j++) {
        //         min = Math.min(min,nums[j]);
        //         max = Math.max(max,nums[j]);
        //         total += max-min;
        //     }
        // }
        // return total;
    }
}