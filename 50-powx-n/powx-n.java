class Solution {
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE) {
            x = x*x;
            n = n/2;
        }
        long nn = n;
        if(nn < 0) nn = -1*n;
        double ans = 1;
        while(nn > 0) {
            if(nn % 2 == 1) {
                ans  = ans*x;
                nn = nn-1;
            } else {
                x  = x*x;
                nn = nn/2;
            }
        }
        if(n < 0) return (1.0)/ans;
        return ans;
    }
}