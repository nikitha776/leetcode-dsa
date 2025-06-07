class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefSum = 0;

        for(int i = 0;i < n;i++) {
            prefSum += nums[i];
            int rem = prefSum % k;
            if(rem == 0 && i > 0) return true;
            if(!map.containsKey(rem)) {
                map.put(rem,i);
            }
            else if(i-map.get(rem) > 1) {
                return true;
            }
        }
        return false;
    }
}