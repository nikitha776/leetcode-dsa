class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = 0;
        int r = n-1;
        int lsum = 0;
        int rsum = 0;
        int sum = 0;

        for(int i = 0;i < k;i++) {
            lsum += cardPoints[i];
        }

        sum = lsum;

        for(int i = k-1;i >= 0;i--) {
            lsum -= cardPoints[i];
            rsum += cardPoints[r];
            r--;
            sum = Math.max(sum,lsum+rsum);
        }

        return sum;
    }
}