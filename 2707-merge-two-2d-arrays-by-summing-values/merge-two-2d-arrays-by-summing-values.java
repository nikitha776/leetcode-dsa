class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        List<int[]> arr = new ArrayList<>();
        while(i < n && j < m) {
            if(nums1[i][0] < nums2[j][0]) {
                int[] a = new int[2];
                a[0] = nums1[i][0];
                a[1] = nums1[i][1];
                arr.add(a);
                i++;
            } else if(nums1[i][0] > nums2[j][0]) {
                int[] a = new int[2];
                a[0] = nums2[j][0];
                a[1] = nums2[j][1];
                arr.add(a);
                j++;
            } else {
                int[] a = new int[2];
                a[0] = nums1[i][0];
                a[1] = nums1[i][1]+nums2[j][1];
                arr.add(a);
                i++;
                j++;
            }
        }
        while(i < n) {
            int[] a = new int[2];
            a[0] = nums1[i][0];
            a[1] = nums1[i][1];
            arr.add(a);
            i++;
        }
        while(j < m) {
            int[] a = new int[2];
            a[0] = nums2[j][0];
            a[1] = nums2[j][1];
            arr.add(a);
            j++;
        }
        int[][] res = new int[arr.size()][2];
        for(i = 0;i < arr.size();i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}