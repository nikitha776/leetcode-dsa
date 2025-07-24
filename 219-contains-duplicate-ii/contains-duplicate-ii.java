class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        int right  = 0;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        while(right < n) {
            int diff = right - left;
            while(diff > k) {
                set.remove(nums[left]);
                left++;
                diff = right - left;
            }
            if(set.contains(nums[right]) && diff != 0) {
                System.out.println(left + " " + right);
                return true;
            }
            set.add(nums[right]);
            right++;
        }
        return false;
    }
}