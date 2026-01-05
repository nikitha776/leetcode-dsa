class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int negatives = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                sum += Math.abs(matrix[i][j]);
                if(matrix[i][j] < 0) negatives++;
                min = Math.min(min,Math.abs(matrix[i][j]));
            }
        }
        if(negatives % 2 == 0) return sum;
        return sum - 2*min;
    }
}