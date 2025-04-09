class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        int[] res = new int[2];
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(target == sum) {
                res[0] = i+1;
                res[1] = j+1;
                return res;
            } else if(target > sum) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}