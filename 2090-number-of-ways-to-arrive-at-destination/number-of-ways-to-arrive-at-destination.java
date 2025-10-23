class Pair {
    int node;
    long dist;
    Pair(int n,long d) {
        node = n;
        dist = d;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        int MOD = (int)1e9 + 7;
        for(int i = 0;i < n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] a : roads) {
            adj.get(a[0]).add(new Pair(a[1],a[2]));
            adj.get(a[1]).add(new Pair(a[0],a[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        pq.add(new Pair(0,0));
        long[] dist = new long[n];
        int[] ways = new int[n];
        ways[0] = 1;
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int curr = p.node;
            long d = p.dist;
            for(Pair i : adj.get(curr)) {
                int adjNode = i.node;
                long adjWt = i.dist;
                if(dist[adjNode] > d + adjWt) {
                    dist[adjNode] = (long)d + adjWt;
                    ways[adjNode] = ways[curr];
                    pq.add(new Pair(adjNode,(long)d+adjWt));
                } else if(dist[adjNode] == d + adjWt) {
                    ways[adjNode] = (ways[adjNode] + ways[curr])%MOD;
                }
            }
        }
        return (int)ways[n-1]%MOD;
    }
}