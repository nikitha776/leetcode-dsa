class Solution {
    public boolean backspaceCompare(String s, String t) {
        int skipS = 0;
        int skipT = 0;
        int i = s.length()-1;
        int j = t.length()-1;

        while(i >= 0 || j >= 0) {
            while(i >= 0) {
                if(s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if(skipS > 0 ) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while(j >= 0) {
                if(t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if(skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if(i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) return false;
            if((i >= 0) != (j >= 0)) return false;
            i--;
            j--;
        }
        return true;

        // Stack<Character> st1 = new Stack<>();
        // Stack<Character> st2 = new Stack<>();
        // for(int i = 0;i < s.length();i++) {
        //     char ch = s.charAt(i);
        //     if(ch == '#') {
        //         if(!st1.isEmpty()) st1.pop();
        //     } else {
        //         st1.push(ch);
        //     }
        // }
        // for(int i = 0;i < t.length();i++) {
        //     char ch = t.charAt(i);
        //     if(ch == '#') {
        //         if(!st2.isEmpty()) st2.pop();
        //     } else {
        //         st2.push(ch);
        //     }
        // }
        // if(st1.size() != st2.size()) return false;
        // if(st1.size() == 0 && st2.size() == 0) return true;
        // while(!st1.isEmpty()) {
        //     if(st1.pop() != st2.pop()) return false;
        // }
        // return true;
    }
}