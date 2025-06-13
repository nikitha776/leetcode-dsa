class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for(int i = 0;i < n;i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch,map.get(ch)+1);
                if(map.get(ch) >= 2) return ch;;
            }
            else map.put(ch,1);

        }
        return ' ';
    }
}