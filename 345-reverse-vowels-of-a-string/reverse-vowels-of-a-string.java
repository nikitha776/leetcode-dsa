class Solution {
    public boolean isVowel(char ch) {
        char temp = Character.toLowerCase(ch);
        return temp == 'a' || temp == 'e' || temp == 'i' || temp =='o' || temp == 'u';
    }
    public String reverseVowels(String s) {
        if(s.length() == 0 || s.length() == 1) return s;
        int start = 0;
        int end = s.length()-1;
        char[] arr = s.toCharArray();
        while(start < end) {
            if(!isVowel(arr[start])) {
                start++;
            }
            if(!isVowel(arr[end])) {
                end--;
            }
            if(isVowel(arr[start]) && isVowel(arr[end])) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        String str = new String(arr);
        return str;
    }
}


