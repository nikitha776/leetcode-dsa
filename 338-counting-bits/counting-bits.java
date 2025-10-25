class Solution {
    public int count(int n) {
        int count = 0;
        for(int i = 0;i < 32;i++) {
            if(((1 << i) & n) != 0) count++;
        }
        return count;
    }
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i = 0;i <= n;i++) {
            arr[i] = count(i);
        }
        return arr;
    }
}