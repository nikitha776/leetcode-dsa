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
        // for(int i = low;i <= high;i++) {
        //     if(helper(i)) ans++;
        // }
        for(int i = low;i <= high;i++) {
            if(i < 10) continue;
            else if(i < 100) {
                if((i % 10) == (i /10)) ans += 1;
            }
            else if(i < 1000) continue;
            else if(i < 10000) {
                int a = (i%10);
                int b = (i%100)/10;
                int c = (i%1000)/100;
                int d = (i%10000)/1000;
                if((a+b) == (c+d)) ans += 1;
            }
        }
        return ans;
    }
}