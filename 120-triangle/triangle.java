class Solution {
    public int helper(List<List<Integer>> triangle,int[][] dp,int i,int j,int n) {
        if(dp[i][j] != -1) return dp[i][j];
        if(i == n-1) return triangle.get(i).get(j);
        int sum1 = triangle.get(i).get(j) + helper(triangle,dp,i+1,j,n);
        int sum2 = triangle.get(i).get(j) + helper(triangle,dp,i+1,j+1,n);
        return dp[i][j] = Math.min(sum1,sum2);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int[][] dp = new int[n][m];
        for(int i = 0;i < n;i++) {
            Arrays.fill(dp[i],-1);
        }
        for(int j = 0;j < m;j++) {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        for(int i = n-2;i >= 0;i--) {
            for(int j = triangle.get(i).size()-1;j >= 0 ;j--) {
                int sum1 = triangle.get(i).get(j) + dp[i+1][j];
                int sum2 = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(sum1,sum2);
            }
        }
        return dp[0][0];
        // return helper(triangle,dp,0,0,n);
    }
}