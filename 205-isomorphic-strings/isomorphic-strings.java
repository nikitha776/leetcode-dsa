class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i = 0;i < s.length();i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(!map1.containsKey(a)) {
                map1.put(a,i);
            }
            if(!map2.containsKey(b)) {
                map2.put(b,i);
            }
            if(map1.get(a) != map2.get(b)) {
                return false;
            }
        }
        return true;
    }
}