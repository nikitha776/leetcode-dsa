class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int count;
        boolean[] x = new boolean[1001];  
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (x[count]) {
                return false;  
            }
            x[count] = true;  
        }
        return true;  
    }
}