class Pair {
    int x;
    int y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public boolean bfs(int day,int[][] cells,int n,int m) {
        int[][] grid = new int[n+1][m+1];
        for(int i = 0;i <= day;i++) {
            grid[cells[i][0]][cells[i][1]] = 1;
        }
        int srcx = -1;
        int srcy = -1;
        boolean[][] vis = new boolean[n+1][m+1];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 1;i <= m;i++) {
            if(grid[1][i] == 0) {
                srcx = 1;
                srcy = i;
                q.add(new Pair(srcx,srcy));
                vis[srcx][srcy] = true;
            }
        }
        if(srcx == -1) return false;
        int[] drow = {1,-1,0,0};
        int[] dcol = {0,0,1,-1};
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            if(x == n) return true;
            for(int i = 0;i < 4;i++) {
                int newRow = x + drow[i];
                int newCol = y + dcol[i];
                if(newRow <= n && newCol <= m && newRow >= 1 && newCol >= 1 && grid[newRow][newCol] == 0 && !vis[newRow][newCol]) {
                    vis[newRow][newCol] = true;
                    q.add(new Pair(newRow,newCol));
                } 
            }
        }
        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int s = 0;
        int e = cells.length-1;
        int count = 0;

        while(s <= e) {
            int m = s + (e - s) / 2;
            boolean res = bfs(m,cells,row,col);
            if(res) {
                count = m;
                s = m+1;
            }
            else{
                e = m-1;
            }

        }
        return count+1;
    }
}