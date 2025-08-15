class Solution {
    public void dfs(int[][] grid,int row,int col,boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = true;
        int[] r = {1,-1,0,0};
        int[] c = {0,0,1,-1};

        for(int i = 0;i < 4;i++) {
            int ridx = row+r[i];
            int cidx = col+c[i];
            if(ridx >= 0 && ridx < n && cidx >= 0 && cidx < m && grid[ridx][cidx] == 1 && !vis[ridx][cidx]) {
                dfs(grid,ridx,cidx,vis);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0;i < n;i++) {
            if(grid[i][0] == 1 && !vis[i][0]) {
                dfs(grid,i,0,vis);
            }
            if(grid[i][m-1] == 1 && !vis[i][m-1]) {
                dfs(grid,i,m-1,vis);
            }
        }
        for(int j = 0;j < m;j++) {
            if(grid[0][j] == 1 && !vis[0][j]) {
                dfs(grid,0,j,vis);
            }
            if(grid[n-1][j] == 1 && !vis[n-1][j]) {
                dfs(grid,n-1,j,vis);
            }
        }
        int count = 0;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(grid[i][j] == 1 && !vis[i][j]) count++;
            }
        }
        return count;
    }
}