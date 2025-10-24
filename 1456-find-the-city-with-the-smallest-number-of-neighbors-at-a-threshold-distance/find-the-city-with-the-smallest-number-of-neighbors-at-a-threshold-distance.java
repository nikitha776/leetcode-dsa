class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i = 0;i < n;i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for(int[] a : edges) {
            dist[a[0]][a[1]] = a[2];
            dist[a[1]][a[0]] = a[2];
        }
        for(int via = 0;via < n;via++) {
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < n;j++) {
                    if(dist[i][via] == Integer.MAX_VALUE || dist[via][j] == Integer.MAX_VALUE) continue;
                    int d = dist[i][via] + dist[via][j];
                    if(d < dist[i][j]) dist[i][j] = d;
                }
            }
        }
        int minCity = -1;
        int minCount = n+1;
        for(int i = 0;i < n;i++) {
            int count = 0;
            for(int j = 0;j < n;j++) {
                if(dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if(minCount >= count) {
                minCount = count;
                minCity = i;
            }
        }
        return minCity;
    }
}