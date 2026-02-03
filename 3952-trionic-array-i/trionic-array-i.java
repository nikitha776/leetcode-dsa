class Solution {
    public boolean isTrionic(int[] nums) {
        boolean first = false;
        boolean second = false;
        boolean third = false;
        int n = nums.length;

        int i = 0;
        int j = 1;
        while(j < n && nums[i] < nums[j]) {
            i++;
            j++;
        }
        if(i != 0) first = true;
        // i = j;
        // j = i+1;
        int temp = i;
        while(j < n && nums[i] > nums[j]) {
            i++;
            j++;
        }
        if(i != temp) second = true;
        temp = i;
        while(j < n && nums[i] < nums[j]) {
            i++;
            j++;
        }
        if(i != temp && j == n) third = true;
        return first && second && third;
    }
}