class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        // Arrays.sort(nums);
        // int i = 0;
        // int j = 0;
        // int len = 0;
        // int maxLen = 0;
        // while(j < n) {
        //     if(nums[j] - nums[i] == 1) {
        //         maxLen = Math.max(maxLen,j-i+1);
        //     } else if(nums[j] - nums[i] > 1){
        //         int x = nums[i];
        //         while(nums[i] == x) i++;
        //     } 
        //     j++;
        // }
        
        Map<Integer,Integer> map = new HashMap<>();
        int maxLen = 0;

        for(int i = 0;i < n;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int num : map.keySet()) {
            if(map.containsKey(num + 1)) {
                int len = map.get(num) + map.get(num+1);
                maxLen = Math.max(maxLen,len);
            }
        }

        return maxLen;
    }
}