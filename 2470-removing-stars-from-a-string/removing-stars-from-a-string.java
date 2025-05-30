class Solution {
    public String removeStars(String s) {
        // Stack<Character> st = new Stack<>();
        // int n = s.length();
        // for(int i = 0;i < n;i++) {
        //     char ch = s.charAt(i);
        //     if(ch == '*') {
        //         st.pop();
        //     } else {
        //         st.push(ch);
        //     }
        // }
        // String ans = "";
        // while(!st.isEmpty()) {
        //     ans = st.pop() + ans;
        // }
        // return ans;
        int i = s.length()-1;
        int skip = 0;
        String ans = "";
        while(i >= 0) {
            char ch = s.charAt(i);
            if(ch == '*') {
                skip++;
                i--;
            }
            else if(skip > 0) {
                skip--;
                i--;
            }
            else {
                ans = ch + ans;
                i--;
            }
        }
        return ans;
    }
}