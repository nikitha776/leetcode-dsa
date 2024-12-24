class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(int i = 0;i < s.length();i++) {
            int idx = 122 - s.charAt(i);
            arr[idx]++; 
        }
        for(int i = 0;i < s.length();i++) {
            if(arr[122 - s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}