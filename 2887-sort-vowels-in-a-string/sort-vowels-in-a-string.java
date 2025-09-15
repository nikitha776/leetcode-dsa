class Solution {
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        List<Character> list = new ArrayList<>();
        for(char ch : s.toCharArray()) {
            if(isVowel(ch)) list.add(ch);
        }
        Collections.sort(list);
        int j = 0;
        for(int i = 0;i < sb.length();i++) {
            char ch = sb.charAt(i);
            if(isVowel(ch)) {
                sb.setCharAt(i,list.get(j));
                j++;
            }
        }
        return sb.toString();
    }
}