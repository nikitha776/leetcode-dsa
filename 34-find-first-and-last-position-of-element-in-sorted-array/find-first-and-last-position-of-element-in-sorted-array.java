class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] a = new int[2];
        a[0] = -1;
        a[1] = -1;
        int start = 0;
        int end = nums.length - 1;
        // for(int i = 0;i < nums.length;i++) {
        //     if(nums[i] == target) {
        //         a[0] = i;
        //         i++;
        //         while(i < nums.length && nums[i] == target) {
        //             i++;
        //         }
        //         a[1] = i-1;
        //         break;
        //     }
        // }
        while(start <= end) {
            int mid = start + ((end - start) / 2);
            if(nums[mid] > target) {
                end = mid - 1;
            }
            else if(nums[mid] < target) {
                start = mid + 1;
            }
            else {
                int t1 = mid-1;
                int t2 = mid+1;
                while(t1 >= 0 && nums[mid] == nums[t1]) {
                    t1--;
                }
                while(t2 < nums.length && nums[mid] == nums[t2]) {
                    t2++;
                } 
                a[0] = t1+1;
                a[1] = t2-1;
                return a;
            }
        }
        return a;
        
    }
}