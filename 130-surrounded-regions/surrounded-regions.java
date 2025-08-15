class Solution {
    public void dfs(char[][] board,int row,int col,boolean[][] vis) {
        int n = board.length;
        int m = board[0].length;
        vis[row][col] = true;
        int[] r = {-1,1,0,0};
        int[] c = {0,0,1,-1};
        for(int i = 0;i < 4;i++) {
            if(row+r[i] >= 0 && row+r[i] < n && col+c[i] >= 0 && col+c[i] < m && board[row+r[i]][col+c[i]] == 'O' && !vis[row+r[i]][col+c[i]]) {
                dfs(board,row+r[i],col+c[i],vis);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0;i < n;i++) {
            if(board[i][0] == 'O' && !vis[i][0]) {
                dfs(board,i,0,vis);
            }
            if(board[i][m-1] == 'O' && !vis[i][m-1]) {
                dfs(board,i,m-1,vis);
            }
        }
        for(int j = 0;j < m;j++) {
            if(board[0][j] == 'O' && !vis[0][j]) {
                dfs(board,0,j,vis);
            }
            if(board[n-1][j] == 'O' && !vis[n-1][j]) {
                dfs(board,n-1,j,vis);
            }
        }

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(board[i][j] == 'O' && !vis[i][j]) board[i][j] = 'X';
            }
        }
    }
}