class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int plen = strs[0].length();
        String pstr  = strs[0];
        for(int i = 1;i < strs.length;i++) {
            String temp = strs[i];
            while(plen > temp.length() || !pstr.equals(temp.substring(0,plen))) {
                plen--;
                if(plen == 0) return "";
                pstr  = pstr.substring(0,plen);
            }
        }
        return pstr;
    }
}