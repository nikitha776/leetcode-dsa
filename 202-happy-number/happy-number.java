class Solution {
    public boolean isHappy(int n) {
        if(n == 1 || n == 7) return true;
        else if(n < 9) return false;
        else {
            int temp = 0;
            while(n > 0) {
                int r = n % 10;
                n = n / 10;
                temp = temp + (r*r);
            }
            return isHappy(temp);
        }
    }
}