class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int count = 1;
        char ch = Character.MIN_VALUE;
        String str = "";
        for(int i = 0;i < n-1;i++) {
            char ch1 = num.charAt(i);
            char ch2 = num.charAt(i+1);
            if(ch1 == ch2) {
                count++;
                if(count == 3) {
                    if(ch1 > ch) {
                        str = "";
                        str = str + ch1 + ch1 + ch1;
                        ch = ch1;
                        System.out.println(str);
                    }
                }
            } else {
                count = 1;
            }
        }
        return str;
    }
}