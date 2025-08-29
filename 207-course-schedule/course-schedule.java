class Solution {
    // public boolean dfs(List<List<Integer>> adj,int[] vis,int[] path,int curr) {
    //     vis[curr] = 1;
    //     path[curr] = 1;
    //     for(int i : adj.get(curr)) {
    //         if(vis[i] == 0) {
    //             if(dfs(adj,vis,path,i)) return true;
    //         } else if(path[i] == 1) {
    //             return true;
    //         }
    //     }
    //     path[curr] = 0;
    //     return false;
    // }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < numCourses;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites) {
            adj.get(arr[1]).add(arr[0]);
        }
        // int[] vis = new int[numCourses];
        // int[] path = new int[numCourses];
        // for(int i = 0;i < numCourses;i++) {
        //     if(vis[i] == 0) {
        //         if(dfs(adj,vis,path,i)) return false;
        //     }
        // }
        // return true;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        for(int[] arr : prerequisites) {
            indegree[arr[0]]++;
        }
        for(int i = 0;i < numCourses;i++) {
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int curr = q.poll();
            list.add(curr);
            for(int i : adj.get(curr)) {
                indegree[i]--;
                if(indegree[i] == 0) q.add(i);
            }
        }
        return list.size() == numCourses;
    }
}