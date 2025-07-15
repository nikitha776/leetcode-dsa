class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if(n < 3) return false;
        boolean hasVowel = false;
        boolean hasConsonant = false;

        for(int i = 0;i < n;i++) {
            char x = word.charAt(i);
            char ch = Character.toLowerCase(x);
            if(Character.isLetter(ch)) {
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else if(!Character.isDigit(ch)){
                return false;
            }
        }

        return hasVowel && hasConsonant;
    }
}