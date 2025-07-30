class Pair {
    int row;
    int col;
    Pair(int row,int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(char[][] grid,int i,int j,boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j] = true;
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            if(row > 0 && grid[row-1][col] == '1' && !vis[row-1][col]) {
                vis[row-1][col] = true;
                q.add(new Pair(row-1,col));
            }
            if(row < n-1 && grid[row+1][col] == '1' && !vis[row+1][col]) {
                vis[row+1][col] = true;
                q.add(new Pair(row+1,col));
            }
            if(col > 0 && grid[row][col-1] == '1' && !vis[row][col-1]) {
                vis[row][col-1] = true;
                q.add(new Pair(row,col-1));
            }
            if(col < m-1 && grid[row][col+1] == '1' && !vis[row][col+1]) {
                vis[row][col+1] = true;
                q.add(new Pair(row,col+1));
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int ans = 0;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    ans++;
                    bfs(grid,i,j,vis);
                }
            }
        }
        return ans;
    }
}