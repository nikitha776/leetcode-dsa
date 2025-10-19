class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < numCourses;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites) {
            adj.get(arr[1]).add(arr[0]);
        }
        int[] indegree = new int[numCourses];
        for(int[] arr : prerequisites) {
            indegree[arr[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < numCourses;i++) {
            if(indegree[i] == 0) q.add(i);
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            ans[idx++] = curr;
            for(int i : adj.get(curr)) {
                indegree[i]--;
                if(indegree[i] == 0) q.add(i);
            }
        }
        if(idx != numCourses) return new int[0];
        return ans;
    }
}