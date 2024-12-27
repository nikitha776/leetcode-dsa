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

// class Solution {
//     public String reverseWords(String s) {
//         StringBuilder sb = new StringBuilder();
//         StringBuilder temp = new StringBuilder();
        
//         for (int i = s.length() - 1; i >= 0; i--) {
//             char ch = s.charAt(i);
            
//             if (ch != ' ') {
//                 temp.append(ch); // Collect characters for the current word
//             } else if (temp.length() > 0) { // Append the word if ready
//                 if (sb.length() > 0) {
//                     sb.append(" "); // Add space between words
//                 }
//                 sb.append(temp.reverse()); // Reverse and append the word
//                 temp.setLength(0); // Clear temp for the next word
//             }
//         }
        
//         // Append the last word if there's no trailing space
//         if (temp.length() > 0) {
//             if (sb.length() > 0) {
//                 sb.append(" ");
//             }
//             sb.append(temp.reverse());
//         }
        
//         return sb.toString();
//     }
// }
