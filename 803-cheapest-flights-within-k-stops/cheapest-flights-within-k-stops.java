class Pair {
    int node;
    int dist;
    int stops;
    Pair(int n,int d,int s) {
        node = n;
        dist = d;
        stops = s;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] a : flights) {
            adj.get(a[0]).add(new Pair(a[1],a[2],0));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0,0));
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int curr = p.node;
            int d = p.dist;
            int s = p.stops;
            if(s > k) continue;
            for(Pair i : adj.get(curr)) {
                int x = i.node;
                int y = i.dist;
                if(dist[x] > d + y && s <= k) {
                    dist[x] = d + y;
                    q.add(new Pair(x,d+y,s+1));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}