class Solution {
    public int mostFrequentEven(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++) {
            if(nums[i] % 2 == 0) {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        int maxFreq = 0;
        int ele = -1;
        for(Map.Entry<Integer,Integer> i: map.entrySet()) {
            if(i.getValue() > maxFreq) {
                ele = i.getKey();
                maxFreq = i.getValue();
            } else if(i.getValue() == maxFreq) {
                if(ele > i.getKey()) {
                    ele = i.getKey();
                }
            }
        }
        return ele;
    }
}