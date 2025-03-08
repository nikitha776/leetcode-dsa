class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int len = n + m;
        int i = 0;
        int j = 0;
        int x = 0;
        int y = 0;
        int k = 0;

        while(k <= (m+n)/2) {
            y = x;
            if(i < n && j < m) {
                if(nums1[i] < nums2[j]) {
                    x = nums1[i++];
                } else {
                    x = nums2[j++];
                }
            }
            else {
                if(i < n) {
                    x = nums1[i++];
                }
                if(j < m) {
                    x = nums2[j++];
                }
            }
            k++;
        }
        if((m+n)%2 != 0) return (double)x;
        else return (double) (x+y)/2;
    }
}