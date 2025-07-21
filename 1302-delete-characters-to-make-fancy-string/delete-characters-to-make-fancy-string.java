// class Solution {
//     public String makeFancyString(String s) {
//         int j = 1;
//         int count = 0;
//         String res = "";
//         int n = s.length();

//         res += s.charAt(0);
//         for(int i = 1;i < n;i++) {
//             if(s.charAt(i) != s.charAt(i-1)) {
//                 count = 0;
//             } else {
//                 count++;
//             }
//             if(count < 2) {
//                 res += s.charAt(i);
//             }
//         }
//         return res;
//     }
// }

class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        int count = 1;

        res.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count < 3) {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}
