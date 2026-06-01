class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        Arrays.sort(cost);
        int minCost = 0;

        for(int i = n-2;i >= 0;i-=3) {
            if(i >= 0) {
                minCost += (cost[i]+cost[i+1]);
            }
        }

        if (n % 3 == 1) {
            minCost += cost[0];
        }
        return minCost;
    }
}