class Solution {
    public int helper(int[][] mat,int[][] dp,int i,int j) {
        if(j < 0 || j > mat.length-1) return (int) 1e9;
        if(i == mat.length-1) return mat[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int sum1 = mat[i][j] + helper(mat,dp,i+1,j-1);
        int sum2 = mat[i][j] + helper(mat,dp,i+1,j);
        int sum3 = mat[i][j] + helper(mat,dp,i+1,j+1);
        return dp[i][j] = Math.min(sum1,Math.min(sum2,sum3));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        // int[][] dp = new int[n][n];
        // for(int i = 0;i < n;i++) {
        //     Arrays.fill(dp[i],-1);
        // }
        // // for(int j = 0;j < n;j++) {
        // //     min = Math.min(min,helper(matrix,dp,0,j));
        // // }
        // // return min;

        // for(int j = 0;j < n;j++) {
        //     dp[n-1][j] = matrix[n-1][j];
        // }
        
        // for(int i = n-2;i >= 0;i--) {
        //     for(int j = n-1;j >= 0;j--) {
        //         int sum1 = Integer.MAX_VALUE;
        //         int sum2 = Integer.MAX_VALUE;
        //         int sum3 = Integer.MAX_VALUE;
        //         if(j > 0) sum1 = matrix[i][j] + dp[i+1][j-1];
        //         sum2 = matrix[i][j] + dp[i+1][j];
        //         if(j < n-1) sum3 = matrix[i][j] + dp[i+1][j+1];
        //         dp[i][j] = Math.min(sum1,Math.min(sum2,sum3));
        //     }
        // }

        // for(int i = 0;i < n;i++) {
        //     min = Math.min(min,dp[0][i]);
        // }
        // return min;

        int[] next = new int[n];

        for(int j = 0;j < n;j++) {
            next[j] = matrix[n-1][j];
        }

        for(int i = n-2;i >= 0;i--) {
            int[] temp = new int[n];
            for(int j = n-1;j >= 0;j--) {
                int sum1 = Integer.MAX_VALUE;
                int sum2 = Integer.MAX_VALUE;
                int sum3 = Integer.MAX_VALUE;
                if(j > 0) sum1 = matrix[i][j] + next[j-1];
                sum2 = matrix[i][j] + next[j];
                if(j < n-1) sum3 = matrix[i][j] + next[j+1];
                temp[j] = Math.min(sum1,Math.min(sum2,sum3));
            }
            next = temp;
        }
        for(int i = 0;i < n;i++) {
            min = Math.min(min,next[i]);
        }
        return min;
    }
}