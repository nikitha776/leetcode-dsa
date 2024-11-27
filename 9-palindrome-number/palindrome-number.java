class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int n = 0;
        while(temp > 0) {
            int r = temp % 10;
            n = n*10 + r;
            temp = temp / 10;
        }
        if(n == x) {
            return true;
        }
        return false;
    }
}