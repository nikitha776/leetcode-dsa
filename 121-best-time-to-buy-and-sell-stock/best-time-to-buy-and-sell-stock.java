class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        int n = prices.length;

        for(int i = 0;i < n;i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                max = Math.max(max,prices[i]-minPrice);
            }
        }
        return max;
    }
}