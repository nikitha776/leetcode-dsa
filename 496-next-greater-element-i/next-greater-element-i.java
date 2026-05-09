class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums2.length;
        for(int i = n-1;i >= 0;i--) {
            while(!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            if(!st.isEmpty()) map.put(nums2[i],st.peek());
            else map.put(nums2[i],-1);
            st.push(nums2[i]);
        }
        int m = nums1.length;
        int[] res = new int[m];
        for(int i = 0;i < m;i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}