class Solution {
    public int countPrimes(int n) {
        int count = 0;
        int[] primes = new int[n+1];
        Arrays.fill(primes,1);
        for(int i = 2;i <= n;i++) {
            if(primes[i] == 1) {
                for(int j = i*2;j < n;j += i) {
                    primes[j] = 0;
                }
            }
        }
        for(int i = 2;i < n;i++) {
            if(primes[i] == 1) count++;
        }
        return count;
    }
}