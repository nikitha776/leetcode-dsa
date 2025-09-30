class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        int newLen = n;
        while(newLen != 1) {
            int[] temp = new int[newLen-1];
            for(int i = 0;i < newLen-1;i++) {
                temp[i] = (nums[i]+nums[i+1])%10; 
                nums[i] = temp[i];
            }
            newLen--;
        }
        return nums[0];
    }
}