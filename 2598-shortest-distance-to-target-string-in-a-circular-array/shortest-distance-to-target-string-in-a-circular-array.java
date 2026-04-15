class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int min = n;
        for(int i = 0;i < n;i++) {
            if(words[i].equals(target)) {
                int diff = Math.abs(i - startIndex);
                min = Math.min(min,Math.min(diff,n-diff));
            }
        }
        return min < n ? min : -1;
    }
}