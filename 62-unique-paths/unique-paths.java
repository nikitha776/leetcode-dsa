class Solution {
    public int helper(int m,int n,int i,int j,int[][] dp) {
        if(i == 0 && j == 0) return dp[i][j] = 1;
        if(i < 0 || j < 0 || i > m-1 || j > n-1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int top = helper(m,n,i-1,j,dp);
        int left = helper(m,n,i,j-1,dp);
        return dp[i][j] = top+left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++) {
            Arrays.fill(dp[i],-1);
        }
        return helper(m,n,m-1,n-1,dp);
    }
}