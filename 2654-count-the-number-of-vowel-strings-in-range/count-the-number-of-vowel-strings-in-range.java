class Solution {
    public boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for(int i = left;i <= right;i++) {
            int n = words[i].length();
            char ch1 = words[i].charAt(0);
            char ch2 = words[i].charAt(n-1);
            if(isVowel(ch1) && isVowel(ch2)) count++;
        }
        return count;
    }
}