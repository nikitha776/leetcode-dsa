class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int prefSum = 0;
        int count = 0;
        map.put(0,1);
        for(int i = 0;i < n;i++) {
            prefSum += nums[i];
            int rem = prefSum % k;
            if(rem < 0) rem += k;
            if(!map.containsKey(rem)) {
                map.put(rem,1);
            }
            else {
                count += map.get(rem);
                map.put(rem,map.get(rem)+1);
            }
        }
        return count;
    }
}