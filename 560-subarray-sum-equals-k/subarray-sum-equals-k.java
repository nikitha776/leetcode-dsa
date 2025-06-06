class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;

        for(int i = 0;i < n;i++) {
            sum += nums[i];
            if(sum == k) {
                count++;
            }
            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            if(map.containsKey(sum)) {
                map.put(sum,map.get(sum)+1);
            } else {
                map.put(sum,1);
            }
        }

        return count;
    }
}
