class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Stack<Integer> st = new Stack<>();
        // HashMap<Integer,Integer> map = new HashMap<>();

        // int n = nums1.length;
        // int m = nums2.length;

        // int[] res = new int[n];
        // for(int i = m-1;i >= 0;i--) {
        //     if(i == m-1) {
        //         map.put(nums2[i],-1);
        //         st.push(nums2[i]);
        //         continue;
        //     }
        //     while(!st.isEmpty() && st.peek() < nums2[i]) {
        //         st.pop();
        //     }
        //     if(st.isEmpty()) map.put(nums2[i],-1);
        //     else map.put(nums2[i],st.peek());
        //     st.push(nums2[i]);
        // }
        // for(int i= 0;i < n;i++) {
        //     res[i] = map.get(nums1[i]);
        // }
        // return res;

        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        int n = nums1.length;
        int m = nums2.length;

        int[] res = new int[n];

        for(int i = 0;i < m;i++) {
            while(!st.isEmpty() && nums2[st.peek()] < nums2[i]) {
                map.put(nums2[st.peek()],nums2[i]);
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            map.put(nums2[st.pop()],-1);
        }
        for(int i = 0;i < n;i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}