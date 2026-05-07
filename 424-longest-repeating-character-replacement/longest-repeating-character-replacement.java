class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int maxFreq = 0;
        while(right < n) {
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq,map.get(ch));
            int len = right - left + 1;
            if(len - maxFreq > k) {
                char ch2 = s.charAt(left);
                map.put(ch2,map.get(ch2)-1);
                if(map.get(ch2) == 0) map.remove(ch2);
                left++;
            } else {
                maxLen = Math.max(len,maxLen);
            }
            right++;
        }
        return maxLen;
    }
}