class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int j = 0;
        int count = 1;
        int n = s.length();

        for(int i = 0;i < n;i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch,i);
            } else if(map.get(ch) < j) {
                map.put(ch,i);
                continue;
            } else {
                int len = i-j;
                count = Math.max(len,count);
                j = map.get(ch) + 1;
                map.put(ch,i);
            }
        }
        
        count = Math.max(count,n-j);
        return count;
    }
}