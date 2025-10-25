class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int prevStart = 1;
        int idx = 0;
        int x = 0;
        while(idx < n) {
            total += prevStart + x;
            x++;
            idx++;
            if(idx % 7 == 0) {
                prevStart++;
                x = 0;
            }
        }
        return total;
    }
}