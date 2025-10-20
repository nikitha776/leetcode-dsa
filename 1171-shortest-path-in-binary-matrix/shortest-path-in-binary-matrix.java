class Pair {
    int row;
    int col;
    int dist;
    Pair(int r,int c,int d) {
        row = r;
        col = c;
        dist = d;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        if (n == 1 && grid[0][0] == 0) return 1;
        int[] row = {0,0,1,-1,-1,-1,1,1};
        int[] col = {1,-1,0,0,-1,1,-1,1};
        int[][] dist = new int[n][n];
        for(int i = 0;i < n;i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,1));
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int d = p.dist;
            for(int i = 0;i < 8;i++) {
                int ridx = r + row[i];
                int cidx = c + col[i];
                if(ridx >= 0 && cidx >= 0 && ridx < n && cidx < n && grid[ridx][cidx] == 0) {
                    if(dist[ridx][cidx] > d+1) {
                        dist[ridx][cidx] = d+1;
                        q.add(new Pair(ridx,cidx,d+1));
                        if(ridx == n-1 && cidx == n-1) return d+1;
                    }
                }
            }
        }
        return -1;
    }
}