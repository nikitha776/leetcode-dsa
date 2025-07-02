class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;

        for(int i = 0;i < n;i++) {
            sum += nums[i];
            if(sum == goal) res++;
            if(map.containsKey(sum-goal)) {
                res += map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}