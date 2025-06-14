class Solution {
    public int mostFrequent(int[] nums, int key) {
        int n = nums.length;
        int res = 0;
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 1;i < n;i++) {
            if(nums[i-1] == key) {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
                if(map.get(nums[i]) > max) {
                    max = map.get(nums[i]);
                    res = nums[i];
                }
            }
        }
        
        return res;
    }
}