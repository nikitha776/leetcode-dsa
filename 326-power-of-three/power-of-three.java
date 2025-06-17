class Solution {
    public boolean isPowerOfThree(int n) {
        while(n % 3 == 0 && n >= 3) {
            n = n/3;
            System.out.println(n);
        }
        return n==1;
    }
}