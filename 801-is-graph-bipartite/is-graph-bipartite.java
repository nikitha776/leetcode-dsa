class Solution {
    public boolean dfs(int[][] graph,int curr,int color,int[] vis) {
        vis[curr] = color;
        for(int i : graph[curr]) {
            if(vis[i] == -1) {
                int newColor = color == 0 ? 1 : 0;
                if(!dfs(graph,i,newColor,vis)) return false;
            } else if(vis[i] == color) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        for(int i = 0;i < n;i++) {
            if(vis[i] == -1) {
                if(!dfs(graph,i,0,vis)) return false;
            }
        }
        return dfs(graph,0,0,vis);
    }
}