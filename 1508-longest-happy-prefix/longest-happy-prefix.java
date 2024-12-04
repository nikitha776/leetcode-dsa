class Solution {
    public String longestPrefix(String s) {
        int prefix = 0;
        int suffix = 1;
        int[] lps = new int[s.length()];
        while(suffix < s.length()) {
            if(s.charAt(prefix) == s.charAt(suffix)) {
                lps[suffix] = prefix + 1;
                prefix++;
                suffix++;
            } else {
                if(prefix == 0) {
                    lps[suffix] = 0;
                    suffix++;
                } else {
                    prefix = lps[prefix-1];
                }
            }
        }
        return s.substring(0,lps[s.length()-1]);
    }
}