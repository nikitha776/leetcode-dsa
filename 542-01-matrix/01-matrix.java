class Pair {
    int row;
    int col;
    int steps;
    Pair(int r,int c,int s) {
        row = r;
        col = c;
        steps= s;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] res = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(mat[i][j] == 0) {
                    q.add(new Pair(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0;i < size;i++) {
                Pair t = q.poll();
                int r = t.row;
                int c = t.col;
                int steps = t.steps;
                int[] row = {-1,1,0,0};
                int[] col = {0,0,1,-1}; 
                for(int j = 0;j < 4;j++) {
                    if(r+row[j] >= 0 && c+col[j] >= 0 && r+row[j] < n && c+col[j] < m && mat[r+row[j]][c+col[j]] == 1 && !vis[r+row[j]][c+col[j]]) {
                        vis[r+row[j]][c+col[j]] = true;
                        res[r+row[j]][c+col[j]] = steps+1;
                        q.add(new Pair(r+row[j],c+col[j],steps+1));
                    }
                }
            }
        } 
        return res;
    }
}