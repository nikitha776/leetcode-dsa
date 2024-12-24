class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i : nums1) set1.add(i);
        for(int i : nums2) set2.add(i); 
        for(int i : set1) {
            if(set2.contains(i)) {
                arr.add(i);
            }
        }
        int[] ans = new int[arr.size()];
        for(int i = 0;i < arr.size();i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}