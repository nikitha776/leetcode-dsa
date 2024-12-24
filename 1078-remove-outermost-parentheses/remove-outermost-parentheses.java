class Solution {
    public String removeOuterParentheses(String s) {
        // Stack<Character> st = new Stack<>();
        String ans = "";
        // for(int i = 0;i < s.length();i++) {
        //     if(s.charAt(i) == '(') {
        //         if(!st.isEmpty()) {
        //             ans = ans + s.charAt(i);
        //         }
        //         st.push(s.charAt(i));
        //     }   
        //     if(s.charAt(i) == ')') {
        //         st.pop();
        //         if(!st.isEmpty()) {
        //             ans = ans + s.charAt(i);
        //         }
        //     }
        // }
        // return ans;
        int count = 0;
        for(char j = 0;j < s.length();j++) {
            char i = s.charAt(j);
            if(i == '(') {
                if(count > 0) {
                    ans = ans + i;
                }
                count++;
            }
            if(i == ')') {
                count--;
                if(count > 0) {
                    ans = ans + i;
                }
            }
        }
        return ans;
    }
}