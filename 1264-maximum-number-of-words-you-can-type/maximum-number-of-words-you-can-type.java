class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i < text.length();i++) {
            char ch = text.charAt(i);
            if(ch == ' ') {
                boolean flag = true;
                for(int j = 0;j < brokenLetters.length();j++) {
                    char ch2 = brokenLetters.charAt(j);
                    if(set.contains(ch2)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) count++;
                set.clear();
            } else {
                set.add(ch);
            }
        }
        boolean flag = true;
        for(int j = 0;j < brokenLetters.length();j++) {
            char ch2 = brokenLetters.charAt(j);
            if(set.contains(ch2)) {
                flag = false;
                break;
            }
        }
        if(flag) count++;
        return count;
    }
}