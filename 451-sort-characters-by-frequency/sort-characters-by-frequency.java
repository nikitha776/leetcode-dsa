class Solution {
    public String frequencySort(String s) {
        String str = "";
        HashMap <Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) map.put(ch,map.get(ch)+1);
            else map.put(ch,1);
        }
        ArrayList<Character> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> map.get(b) - map.get(a));
        for(int i = 0;i < list.size();i++) {
            char ch = list.get(i);
            int x = map.get(ch);
            while(x > 0) {
                str = str + ch;
                x--;
            }
        }
        return str;
    }
}