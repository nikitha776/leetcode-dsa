class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int prefSum = 0;

        for(int i = 0;i < n;i++) {
            prefSum += nums[i];
            int rem = prefSum - k;
            if(map.containsKey(rem)) {
                count += map.get(rem);
            }
            if(map.containsKey(prefSum)) {
                map.put(prefSum,map.get(prefSum)+1);
            } else {
                map.put(prefSum,1);
            }
        }

        return count;
    }
}
