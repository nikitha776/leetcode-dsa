class Solution {
    public boolean judgeSquareSum(int c) {
        long start = 0;
        long end = (long)Math.sqrt(c);
        while(start <= end) {
            long x = (long)((start*start)+(end*end));
            if(x == (long)c) {
                return true;
            } else if(x > (long)c) {
                end = end - 1;
            } else {
                start = start + 1;
            }
        }
        return false;
    }
}