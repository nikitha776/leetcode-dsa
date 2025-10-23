class Solution {
    public boolean hasSameDigits(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        for(int i = 0;i < n-2;i++) {
            for(int j = 0;j < n-1;j++) {
                int dig1 = arr[j] - '0';
                int dig2 = arr[j+1] - '0';
                arr[j] = (char)(((dig1 + dig2) % 10) + '0');
            }
        }
        return arr[0] == arr[1];
    }
}