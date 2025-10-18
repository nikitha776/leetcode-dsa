class Solution {
    public boolean dfs(int[][] graph,int[] vis,int i,int color) {
        vis[i] = color;
        int nextColor = color == 0 ? 1 : 0;
        for(int j : graph[i]) {
            if(vis[j] == -1) {
                if(!dfs(graph,vis,j,nextColor)) return false;
            } else if(vis[j] == color) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        for(int i = 0;i < n;i++) {
            if(vis[i] == -1) {
                if(!dfs(graph,vis,i,0)) return false;
            }
        }
        return true;
    }
}