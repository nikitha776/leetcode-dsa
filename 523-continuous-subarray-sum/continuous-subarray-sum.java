class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i < n;i++) {
            sum += nums[i];
            if(sum % k == 0 && i >= 1) return true;
            int rem = sum % k;
            if(map.containsKey(rem)) {
                if((i-map.get(rem)) >= 2) return true;
            }
            else map.put(rem,i);
        }
        return false;
    }
}