class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int maxFreq = 0;
        int total = 0;
        for(int i = 0;i < n;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            int freq = map.get(nums[i]);
            if(freq > maxFreq) {
                maxFreq = freq;
                total = freq;
            } else if(maxFreq == freq) {
                total += freq;
            }
        }
        return total;
    }
}