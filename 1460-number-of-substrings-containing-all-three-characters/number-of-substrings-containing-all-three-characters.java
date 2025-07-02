class Solution {
    public int numberOfSubstrings(String s) {
        int[] map = new int[3];
        int n = s.length();
        int count = 0;
        int left = 0;
        int right = 0;

        while(right < n) {
            char ch = s.charAt(right);
            map[ch-'a']++;
            while(map[0] > 0 && map[1] > 0 && map[2] > 0) {
                count += n - right;
                char ch2 = s.charAt(left);
                map[ch2-'a']--;
                left++;
            }
            right++;
        }
        return count;
    }
}
