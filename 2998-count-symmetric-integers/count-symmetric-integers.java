class Solution {
    public boolean helper(int n) {
        int temp = n;
        int count = 0;
        while(temp > 0) {
            count++;
            temp /= 10;
        }
        if(count % 2 != 0) return false;
        int sum1 = 0;
        int sum2 = 0;
        temp = n;
        for(int i = 0;i < count/2;i++) {
            int x = temp % 10;
            sum1 += x;
            temp = temp/10;
        }
        for(int i = 0;i < count/2;i++) {
            int x = temp % 10;
            sum2 += x;
            temp = temp/10;
        }
        return sum1 == sum2;
    }
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for(int i = low;i <= high;i++) {
            if(helper(i)) ans++;
        }
        return ans;
    }
}