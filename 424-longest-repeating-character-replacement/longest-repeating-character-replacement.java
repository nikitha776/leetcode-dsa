class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int maxCount = 0;

        while(right < n) {
            char ch1 = s.charAt(right);
            map.put(ch1,map.getOrDefault(ch1,0)+1);
            maxCount = Math.max(maxCount,map.get(ch1));
            if(right-left+1-maxCount <= k) {
                maxLen = Math.max(maxLen,right-left+1);
            } else {
                char ch2 = s.charAt(left);
                map.put(ch2,map.get(ch2)-1);
                left++;
            }
            right++;
        }
        return maxLen;
    }
}