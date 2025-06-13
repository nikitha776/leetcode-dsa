class Solution {
    public int firstUniqChar(String s) {
        // int[] arr = new int[26];
        // for(int i = 0;i < s.length();i++) {
        //     int idx = 122 - s.charAt(i);
        //     arr[idx]++; 
        // }
        // for(int i = 0;i < s.length();i++) {
        //     if(arr[122 - s.charAt(i)] == 1) {
        //         return i;
        //     }
        // }
        // return -1;
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch,map.get(ch)+1);
            } else {
                map.put(ch,1);
            }
        }
        for(int i = 0;i < n;i++) {
            char ch = s.charAt(i);
            if(map.get(ch) == 1) return i;
        }
        return -1;
    }
}