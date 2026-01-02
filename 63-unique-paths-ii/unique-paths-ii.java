class Solution {
    public int helper(int[][] grid,int i,int j,int[][] dp) {
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0 || grid[i][j] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int up = helper(grid,i-1,j,dp);
        int left = helper(grid,i,j-1,dp);
        return dp[i][j] = up + left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;

        // int[][] dp = new int[m][n];
        // for(int i = 0;i < m;i++) {
        //     Arrays.fill(dp[i],-1);
        // }
        // return helper(obstacleGrid,m-1,n-1,dp);

        // for(int i = 0;i < m;i++) {
        //     for(int j = 0;j < n;j++) {
        //         if(i == 0 && j == 0) {
        //             dp[i][j] = 1;
        //             continue;
        //         }
        //         int up = 0;
        //         int left = 0;
        //         if(i > 0) up = dp[i-1][j];
        //         if(j > 0) left = dp[i][j-1];
        //         dp[i][j] = up + left;
        //         if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
        //     }
        // }
        // return dp[m-1][n-1];

        int[] prev = new int[m];
        prev[0] = 1;

        for(int i = 0;i < m;i++) {
            int[] temp = new int[n];
            for(int j = 0;j < n;j++) {
                if(i == 0 && j == 0) {
                    temp[0] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if(i > 0) up = prev[j];
                if(j > 0) left = temp[j-1];
                temp[j] = up + left;
                if(obstacleGrid[i][j] == 1) temp[j] = 0;
            }
            prev = temp;
        }
        return prev[n-1];
    }
}