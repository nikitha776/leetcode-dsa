class Solution {
    public boolean helper(boolean[][] vis,char[][] board,String word,int i,int j,int idx) {
        if(idx == word.length()-1) {
            return true;
        }
        vis[i][j] = true;
        int r = board.length;
        int c = board[0].length;
        if(i+1 < r && board[i+1][j] == word.charAt(idx+1) && !vis[i+1][j] && helper(vis,board,word,i+1,j,idx+1)) {
            return true;
        }
        if(i-1 >= 0 && board[i-1][j] == word.charAt(idx+1) && !vis[i-1][j] && helper(vis,board,word,i-1,j,idx+1)) {
            return true;
        }
        if(j-1 >= 0 && board[i][j-1] == word.charAt(idx+1) && !vis[i][j-1] && helper(vis,board,word,i,j-1,idx+1)) {
            return true;
        }
        if(j+1 < c && board[i][j+1] == word.charAt(idx+1) && !vis[i][j+1] && helper(vis,board,word,i,j+1,idx+1)) {
            return true;
        }
        vis[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                if(board[i][j] == word.charAt(0) && helper(vis,board,word,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }
}