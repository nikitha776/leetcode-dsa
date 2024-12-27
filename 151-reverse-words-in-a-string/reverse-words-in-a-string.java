class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int j = s.length();
        for(int i = s.length()-1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(ch != ' ') {
                temp.insert(0,ch);
            }
            if(ch == ' ') {
                if(temp.length() > 0) {
                    sb.append(temp);
                    sb.append(" ");
                }
                temp.setLength(0);
            }
        }
        sb.append(temp);
        return sb.toString().trim();
    }
}

