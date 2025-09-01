class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        int[] indegree = new int[n];
        for(int i = 0;i < n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i < n;i++) {
            for(int j : graph[i]) {
                adj.get(j).add(i);
                indegree[i]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        // for(int i = 0;i < n;i++) {
        //     for(int j : adj.get(i)) {
        //         indegree[j]++;
        //     }
        // }
        for(int i = 0;i < n;i++) {
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int i : adj.get(curr)) {
                indegree[i]--;
                if(indegree[i] == 0) q.add(i);
            }
            res.add(curr);
        }
        Collections.sort(res);
        return res;
    }
}