class Solution {
    public int beautySum(String s) {
        int count = 0;
        for(int i = 0;i < s.length()-1;i++) {
            int[] freq = new int[26];
            for(int j = i;j < s.length();j++) {
                freq[s.charAt(j)-'a']++;
                int max = 0;
                int min = Integer.MAX_VALUE;
                for(int m = 0;m < 26;m++) {
                    if(freq[m] > 0) {
                        max = Math.max(max,freq[m]);
                        min = Math.min(min,freq[m]);
                    }
                }
                count += max - min;
            }
        }
        return count;
    }
}