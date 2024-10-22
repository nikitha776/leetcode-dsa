class Solution {
    public int reverse(int x) {
        int temp =(x>0)?x:-x;
        int sum = 0;
        
        while(temp > 0) {
            int r =  temp % 10;
            if (sum > (Integer.MAX_VALUE - r) / 10) {
                return 0;
            }
            sum = sum*10 + r;
            temp = temp/10;
        }

        

        if(x > 0) return sum;
        else return -sum;
         
    }
}