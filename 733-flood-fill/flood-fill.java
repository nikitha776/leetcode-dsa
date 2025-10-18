class Solution {
    public void dfs(int[][] image,boolean[][] vis,int row,int col,int color,int origColor) {
        if(image[row][col] != color) {
            vis[row][col] = true;
            int[] r = {1,-1,0,0};
            int[] c = {0,0,1,-1};
            image[row][col] = color;
            for(int i = 0;i < 4;i++) {
                int ridx = row+r[i];
                int cidx = col+c[i];
                if(ridx >= 0 && cidx >= 0 && ridx < image.length && cidx < image[0].length && !vis[ridx][cidx] && image[ridx][cidx] == origColor) {
                    dfs(image,vis,ridx,cidx,color,origColor);
                }
            } 
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        dfs(image,vis,sr,sc,color,image[sr][sc]);
        return image;
    }
}