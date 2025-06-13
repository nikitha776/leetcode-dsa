class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        int sum = 0;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                int num = grid[i][j];
                sum += num;
                if(map.containsKey(num)) {
                    map.put(num,map.get(num)+1);
                    if(map.get(num) >= 2) res[0] = num;
                } else {
                    map.put(num,1);
                }
            }
        }
        int x = n*n;
        int y = x*(x+1)/2;
        res[1] = y-sum+res[0];
        return res;
    }
}