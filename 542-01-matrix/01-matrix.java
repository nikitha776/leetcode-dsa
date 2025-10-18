class Pair {
    int row;
    int col;
    int steps;
    Pair(int r,int c,int s) {
        row = r;
        col = c;
        steps = s;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(mat[i][j] == 0) {
                    q.add(new Pair(i,j,0));
                }
            }
        }
        while(!q.isEmpty()) {
            int len = q.size();
            for(int j = 0;j < len;j++) {
                Pair p = q.poll();
                int row = p.row;
                int col = p.col;
                int steps = p.steps;
                int[] r = {1,-1,0,0};
                int[] c = {0,0,1,-1};
                for(int i = 0;i < 4;i++) {
                    int ridx = r[i]+row;
                    int cidx = c[i]+col;
                    if(ridx >= 0 && ridx < n && cidx >= 0 && cidx < m && mat[ridx][cidx] == 1 && !vis[ridx][cidx]) {
                        vis[ridx][cidx] = true;
                        dist[ridx][cidx] = steps+1;
                        q.add(new Pair(ridx,cidx,steps+1));
                    } 
                }
            }
        }
        return dist;
    }
}