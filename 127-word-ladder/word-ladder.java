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
        Set<String> set = new HashSet<>();
        for(String str : wordList) {
            set.add(str);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int steps = p.steps;
            if(word.equals(endWord)) return steps;
            for(int i = 0;i < word.length();i++) {
                for(int j = 0;j < 26;j++) {
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i,(char)('a'+j));
                    String temp = sb.toString();
                    if(set.contains(temp)) {
                        q.add(new Pair(temp,steps+1));
                        set.remove(temp);
                    }
                }
            }
        }
        return 0;
    }
}