class Solution {
    public int[] numberOfPairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            } else {
                map.put(nums[i],1);
            }
        }
        int[] res = new int[2];
        int a = 0;
        int b = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            b += entry.getValue()%2;
            a += entry.getValue()/2;
        }
        res[0] = a;
        res[1] = b;
        return res;
    }
}