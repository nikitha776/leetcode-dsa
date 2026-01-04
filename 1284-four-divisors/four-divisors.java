class Solution {
   private boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public int sumFourDivisors(int[] nums) {
        boolean[] isPrime = sieve(100000);
        int result = 0;

        for (int x : nums) {

            // Case 1: x = p^3
            int p = (int) Math.round(Math.cbrt(x));
            if ((long) p * p * p == x && isPrime[p]) {
                result += 1 + p + p * p + x;
                continue;
            }

            // Case 2: x = p * q (p != q, both prime)
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    int j = x / i;
                    if (i != j && isPrime[i] && isPrime[j]) {
                        result += 1 + i + j + x;
                    }
                    break; // only one such pair possible
                }
            }
        }
        return result;
    }
}