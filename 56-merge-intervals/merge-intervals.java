class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> list = new ArrayList<>();
        for(int[] i : intervals) {
            if(list.size() == 0 || list.getLast()[1] < i[0]) {
                list.add(i);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1],i[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}