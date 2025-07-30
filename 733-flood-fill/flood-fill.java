class Solution {
    public void dfs(int[][] image, int sr, int sc, int color,int oc) {
        if(image[sr][sc] != color) {
            int n = image.length;
            int m = image[0].length;
            image[sr][sc] = color;
            if(sr > 0 && image[sr-1][sc] == oc) dfs(image,sr-1,sc,color,oc);
            if(sr < n-1 && image[sr+1][sc] == oc) dfs(image,sr+1,sc,color,oc);
            if(sc > 0 && image[sr][sc-1] == oc) dfs(image,sr,sc-1,color,oc);
            if(sc < m-1 && image[sr][sc+1] == oc) dfs(image,sr,sc+1,color,oc);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        // for(int i = 0;i < n;i++) {
        //     for(int j = 0;j < m;j++) {
        //         if()
        //     }
        // }
        int oc = image[sr][sc];
        dfs(image,sr,sc,color,oc);
        return image;
    }
}