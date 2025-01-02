class Solution {
    public int maxDepth(String s) {
        int count  = 0;
        int maxCount = 0;
        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) == '(') {
                count++;
                if(count > maxCount) {
                    maxCount  = count;
                }
            }
            if(s.charAt(i) == ')') {
                count--;
            }
        }
        return maxCount;
    }
}