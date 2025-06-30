class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int len = 0;
        int maxLen = 0;
        while(j < n) {
            if(nums[j] - nums[i] == 1) {
                maxLen = Math.max(maxLen,j-i+1);
            } else if(nums[j] - nums[i] > 1){
                int x = nums[i];
                while(nums[i] == x) i++;
            } 
            j++;
        }
        
        return maxLen;
    }
}