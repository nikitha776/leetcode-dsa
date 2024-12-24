class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        String ans = "";
        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) == '(') {
                if(!st.isEmpty()) {
                    ans = ans + s.charAt(i);
                }
                st.push(s.charAt(i));
            }   
            if(s.charAt(i) == ')') {
                st.pop();
                if(!st.isEmpty()) {
                    ans = ans + s.charAt(i);
                }
            }
        }
        return ans;
    }
}