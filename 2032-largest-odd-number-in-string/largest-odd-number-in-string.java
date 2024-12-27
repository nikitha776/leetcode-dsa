class Solution {
    public String largestOddNumber(String num) {
        String max = "";
        for(int i = 0;i < num.length();i++) {
            int n = num.charAt(i) - '0';
            if(n % 2 != 0) {
                // long t = Long.parseLong(num) / (int)Math.pow(10,num.length()-i-1);
                max = num.substring(0,i+1);
            }
        }
        return String.valueOf(max);
    }
}