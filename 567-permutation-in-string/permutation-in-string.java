class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i = 0;i < s1.length();i++) {
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        }
        int left = 0;
        int right = 0;
        int n = s2.length();
        while(right < n) {
            char ch = s2.charAt(right);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            if(right - left + 1 > s1.length()) {
                char ch2 = s2.charAt(left);
                map2.put(ch2,map2.get(ch2)-1);
                if(map2.get(ch2) == 0) map2.remove(ch2);
                left++;
            }
            if(right - left + 1 == s1.length()) {
                boolean flag = true;
                for(char i : map1.keySet()) {
                    if(map1.get(i) - map2.getOrDefault(i, -1) != 0) {
                        flag = false;
                    }
                }
                if(flag) return true;
            } 
            right++;
        }
        return false;
    }
}