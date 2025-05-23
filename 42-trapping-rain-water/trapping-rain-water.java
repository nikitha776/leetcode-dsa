class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = n-1;
        int total = 0;
        while(l < r) {
            leftMax = Math.max(height[l],leftMax);
            rightMax = Math.max(height[r],rightMax);
            if(leftMax < rightMax) {
                total += leftMax - height[l];
                l++;
            } else {
                total += rightMax - height[r];
                r--;
            }
        }
        // int[] prefMax = new int[n];
        // int[] suffMax = new int[n];
        // int total = 0;
        // prefMax[0] = height[0];
        // suffMax[n-1] = height[n-1];

        // for(int i = 1;i < n;i++) {
        //     prefMax[i] = Math.max(height[i],prefMax[i-1]);
        // }
        // for(int i = n-2;i >= 0;i--) {
        //     suffMax[i] = Math.max(height[i],suffMax[i+1]);
        // }

        // for(int i = 0;i < n;i++) {
        //     if(height[i] < prefMax[i] && height[i] < suffMax[i]) {
        //         total += Math.min(prefMax[i],suffMax[i]) - height[i];
        //     }
        // }
        return total;
    }
}