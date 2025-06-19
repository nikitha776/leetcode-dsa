class Solution {
    public int[][] divideArray(int[] nums, int k) {
        // int n = nums.length;
        // int[][] arr = new int[n/3][3];
        // Arrays.sort(nums);
        // for(int i = 0;i < n;i=i+3) {
        //     if(nums[i+2]-nums[i] <= k) {
        //         int[] temp = {nums[i],nums[i+1],nums[i+2]};
        //         arr[i/3] = temp;
        //     } else {
        //         return new int[0][0];
        //     }
        // }
        // return arr;

        int n = nums.length;
        int[][] res = new int[n/3][3];
        int max = nums[0];

        for(int i = 0;i < n;i++) {
            max = Math.max(max,nums[i]);
        }
        
        int[] arr = new int[max+1];
        for(int i = 0;i< n;i++) {
            arr[nums[i]]++;
        }

        int idx = 0;
        for(int i = 0;i <= max;i++) {
            while(arr[i] > 0) {
                nums[idx] = i;
                if((idx+1)%3 == 0) {
                    if(nums[idx]-nums[idx-2] <= k) {
                        int[] temp = {nums[idx-2],nums[idx-1],nums[idx]};
                        res[idx/3] = temp;
                    } else {
                        return new int[0][0];
                    }
                }
                arr[i]--;
                idx++;
            }
        }
        return res;
    }
}