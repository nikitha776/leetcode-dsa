class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int idx = 0;
        for(int i = 0;i < n;i++) {
            if(letters[i] > target) {
                idx = i;
                break;
            }
        }
        return letters[idx];
    }
}