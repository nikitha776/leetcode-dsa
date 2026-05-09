class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int count = 1;
        int i = 0;
        int idx = 0;
        while(i < n) {
            while(i < n-1 && chars[i] == chars[i+1]) {
                i++;
                count++;
            }
            chars[idx++] = chars[i];
            if(count > 1) {
                String c = Integer.toString(count);
                for(char ch : c.toCharArray()) {
                    chars[idx++] = ch;
                }
            }
            i++;
            count = 1;
        }
        return idx;
    }
}