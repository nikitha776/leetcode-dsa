class Solution {
    public int smallestNumber(int n) {
        int num = 0;
        while((int)Math.pow(2,num) <= n) {
            num++;
        }
        return (int)Math.pow(2,num)-1;
    }
}