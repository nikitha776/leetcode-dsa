class Solution {
    public boolean isPalindrome(String s) {
        int b = 0;
        int e = s.length() - 1;
        while(b <= e) {
            char i = s.charAt(b);
            char j = s.charAt(e);
            if(!Character.isLetterOrDigit(i)) b++;
            else if(!Character.isLetterOrDigit(j)) e--;
            else {
                if(Character.toLowerCase(i) != Character.toLowerCase(j)) return false;
                b++;
                e--;
            }
        }
        return true;
    }
}