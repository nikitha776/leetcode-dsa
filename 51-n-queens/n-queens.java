class Solution {
    private boolean isSafe(char[][] board,int row,int col) {
        int n = board.length;

        // north and south
        for(int i = 0; i < n;i++) {
            if(board[i][col] == 'Q') return false;
        }

        // west and east
        for(int i = 0;i < n;i++) {
            if(board[row][i] == 'Q') return false; 
        }

        // north-west
        int i = row;
        int j = col;
        while(i >= 0 && j >= 0) {
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        // south-west
        i = row;
        j = col;
        while(i < n && j >= 0) {
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }

        // south-east
        i = row;
        j = col;
        while(i < n && j < n) {
            if(board[i][j] == 'Q') return false;
            i++;
            j++;
        }

        //north-east
        i = row;
        j = col;
        while(i >= 0 && j < n) {
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }

        return true;
    }
    private void nqueen(char[][] board,int row,List<List<String>> ans) {
        int n = board.length;
        if(row == n) {
            List<String> l = new ArrayList<>();
            for(int i = 0;i < n;i++) {
                String str = "";
                for(int j = 0;j < n;j++) {
                    str += board[i][j];
                }
                l.add(str);
            }
            ans.add(l);
            return;
        }

        for(int j = 0;j < n;j++) {
            if(isSafe(board,row,j)) {
                board[row][j] = 'Q';
                nqueen(board,row+1,ans);
                board[row][j] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n;i++) {
            for(int j = 0;j < n;j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        nqueen(board,0,ans);
        return ans;
    }
}