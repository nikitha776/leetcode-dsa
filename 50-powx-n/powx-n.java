class Solution {
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE) {
            x = x*x;
            n = n/2;
        }
        int p = n < 0 ? -n : n;
        double ans = 1;
        while(p > 0) {
            if(p % 2 == 0) {
                x = x*x;
                p = p/2;
            } else {
                ans = ans*x;
                p = p - 1;
            }
        }
        if(n < 0) return 1/ans;
        return ans;
    }
}