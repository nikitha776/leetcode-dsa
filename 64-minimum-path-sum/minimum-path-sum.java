class Solution {
    public int helper(int[][] grid,int[][] dp,int i,int j) {
        if(i == 0 && j == 0) return grid[i][j];
        if(i < 0 || j < 0) return (int) 1e9;
        if(dp[i][j] != -1) return dp[i][j];
        int up = grid[i][j] + helper(grid,dp,i-1,j);
        int left = grid[i][j] + helper(grid,dp,i,j-1);
        return dp[i][j] = Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // int[][] dp = new int[m][n];
        // for(int i = 0;i < m;i++) {
        //     Arrays.fill(dp[i],-1);
        // }
        // for(int i = 0;i < m;i++) {
        //     for(int j = 0;j < n;j++) {
        //         if(i == 0 && j == 0) {
        //             dp[i][j] = grid[0][0];
        //             continue;
        //         }
        //         int up = (i > 0) ? grid[i][j] + dp[i-1][j] : (int) 1e9;
        //         int left = (j > 0) ? grid[i][j] + dp[i][j-1] : (int) 1e9;
        //         dp[i][j] = Math.min(up,left);
        //     }
        // }
        // return dp[m-1][n-1];
        // return helper(grid,dp,m-1,n-1);

        int[] prev = new int[n];

        for(int i = 0;i < m;i++) {
            int[] temp = new int[n];
            for(int j = 0;j < n;j++) {
                if(i == 0 && j == 0) {
                    temp[j] = grid[i][j];
                    continue;
                }
                int up = (i > 0) ? grid[i][j] + prev[j] : (int) 1e9;
                int left = (j > 0) ? grid[i][j] + temp[j-1] : (int) 1e9;
                temp[j] = Math.min(up,left);
            }
            prev = temp;
        }
        return prev[n-1];
    }
}