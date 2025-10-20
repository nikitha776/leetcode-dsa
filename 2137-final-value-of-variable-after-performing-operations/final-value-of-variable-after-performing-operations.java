class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String str : operations) {
            char[] arr = str.toCharArray();
            char ch = ' ';
            for(int i = 0;i < arr.length;i++) {
                if(!Character.isLetter(arr[i])) {
                    ch = arr[i];
                    break;
                }
            }
            if(ch == '+') x++;
            else if(ch == '-') x--;
        }
        return x;
    }
}