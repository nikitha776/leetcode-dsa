class Solution {
    public char kthCharacter(int k) {
        String str = "a";
        while(str.length() < k) {
            int n = str.length();
            for(int i = 0;i < n;i++) {
                char ch = str.charAt(i);
                if(ch != 'z') {
                    str += (char)(ch+1);
                } else {
                    str += 'a';
                }
            }
        }
        System.out.print(str);
        return str.charAt(k-1);
    }
}