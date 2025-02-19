class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0;i < nums.length;i++) {
            pq.add((long)nums[i]);
        }
        int count  = 0;
        while(pq.size() >= 2 && pq.peek() < k) {
            count++;
            long a = pq.poll();
            long b = pq.poll();
            pq.add((a*2) + b);
        }
        return count;
    }
}