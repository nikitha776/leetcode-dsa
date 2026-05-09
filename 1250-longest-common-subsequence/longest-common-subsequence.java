class Solution {
    public int helper(int idx1,int idx2,String str1,String str2,int[][] dp) {
        if(idx1 < 0 || idx2 < 0) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        if(str1.charAt(idx1) == str2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + helper(idx1-1,idx2-1,str1,str2,dp);
        }
        return dp[idx1][idx2] = Math.max(helper(idx1-1,idx2,str1,str2,dp),helper(idx1,idx2-1,str1,str2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int i = 0;i < n;i++) {
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,m-1,text1,text2,dp);
    }
}