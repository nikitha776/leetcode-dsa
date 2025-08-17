class Pair {
    String word;
    int steps;
    Pair(String w,int s) {
        word = w;
        steps = s;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String str : wordList) {
            set.add(str);
        }
        set.remove(beginWord);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int steps = p.steps;
            if(word.equals(endWord)) return steps;
            for(int i = 0;i < word.length();i++) {
                for(char ch = 'a';ch <= 'z';ch++) {
                    char[] str = word.toCharArray();
                    str[i] = ch;
                    String newWord = new String(str);
                    if(set.contains(newWord)) {
                        q.add(new Pair(newWord,steps+1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}