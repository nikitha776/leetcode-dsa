class Solution {
    public void dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[curr] = true;
        for(int i : adj.get(curr)) {
            if(!vis[i]) {
                dfs(i,adj,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i = 0;i < n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0;i < n;i++) {
            if(!vis[i]) {
                count++;
                dfs(i,adj,vis);
            }
        }
        return count;
    }
}