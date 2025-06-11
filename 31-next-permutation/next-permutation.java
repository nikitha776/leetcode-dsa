class Solution {
    public void reverse(int[] arr,int s,int e) {
        while(s <= e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx1 = -1;
        for(int i = n-2;i >= 0;i--) {
            if(nums[i] < nums[i+1]) {
                idx1 = i;
                break;
            }
        }
        System.out.println(idx1);
        if(idx1 == -1) {
            reverse(nums,0,n-1);
            return;
        }
        int idx2 = n-1;
        while(nums[idx2] <= nums[idx1]) {
            idx2--;
        }
        System.out.println(idx2);
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
        reverse(nums,idx1+1,n-1);
    }
}