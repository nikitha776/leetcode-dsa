class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int m = bank[0].length();
        int[] devices = new int[n];
        int count = 0;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(bank[i].charAt(j) == '1') devices[i]++; 
            }
        }
        for(int i = 0;i < n-1;i++) {
            for(int j = i+1;j < n;j++) {
                if(devices[j] == 0) continue;
                else {
                    count += devices[i]*devices[j];
                    break;
                }
            }
        }
        return count;
    }
}