class Solution {
    public static final int M = 1000000007;
    public long pow(long x ,long n) {
        long nn = n;
        long ans = 1;
        while(nn > 0) {
            if(nn % 2 == 1) {
                ans  = ans*x % M;
                nn = nn - 1;
            } else {
                x = x*x % M;
                nn = nn / 2;
            }
        }
        return ans;
    }
    public int countGoodNumbers(long n) {
        return (int) ((pow(5,(n+1)/2) * pow(4,n/2)) % M);
    }
}