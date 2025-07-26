class Solution {
    public int addDigits(int num) {
        int n = num;
        while(n / 10 != 0) {
            int sum = 0;
            int temp = n;
            while(temp != 0) {
                sum += temp%10;
                temp = temp/10;
            }
            n = sum;
        }
        return n;
    }
}