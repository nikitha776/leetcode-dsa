class Solution {
    public int singleNumber(int[] nums) {

        // Arrays.sort(nums);
        // for(int i = 1;i < nums.length;i = i+3) {
        //     if(nums[i-1] != nums[i]) {
        //         return nums[i-1];
        //     }
        // }
        // return nums[nums.length-1];

        int ans = 0;
        for(int i = 0;i < 32;i++) {
            int count  = 0;
            for(int j = 0;j < nums.length;j++) {
                if((nums[j] & (1 << i)) != 0) {
                    count++;
                }
            }
            if(count % 3 != 0) {
                ans = ans | (1 << i);
            }
        }
        return ans;
    }
}