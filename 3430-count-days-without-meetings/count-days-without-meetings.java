class Solution {
    public int countDays(int days, int[][] meetings) {
        int count = 0;
        Arrays.sort(meetings,(a,b) -> a[0]-b[0]);
        int prevEnd = 0;
        for(int[] arr : meetings) {
            int start = arr[0];
            int end = arr[1]; 
            if(prevEnd + 1 < start) {
                count += start - (prevEnd+1);
            }
            prevEnd = Math.max(end,prevEnd);
        }
        if(prevEnd < days) {
            count += (days - prevEnd);
        }
        return count;
    }
}