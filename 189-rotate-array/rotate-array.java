class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(nums.length == 1) return;
        int n= nums.length;
        int[] temp = new int[k];
        for(int i = 0;i < k;i++) {
            temp[i] = nums[n-k+i];
        }
        for(int i = n-1;i >= k;i--) {
            nums[i] = nums[i-k];
        }
        for(int i = 0;i < k;i++) {
            nums[i] = temp[i];
        }
        
        // reverse(nums,0,nums.length-1);
        // reverse(nums,0,k-1);
        // reverse(nums,k,nums.length-1);
    }
    // public static void reverse(int[] nums,int s,int e) {
    //     while(s < e) {
    //         int temp = nums[s];
    //         nums[s] = nums[e];
    //         nums[e] = temp;
    //         s++;
    //         e--;
    //     }
    // }
}