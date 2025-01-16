class Solution {
    public String removeDigit(String number, char digit) {
        String max = "";
        for(int i = 0;i < number.length();i++) {
            if(number.charAt(i) == digit) {
                String str = number.substring(0,i) + number.substring(i+1);
                if(str.compareTo(max) > 0) {
                    max = str;
                }
            }
        }
        return max;
    }
}