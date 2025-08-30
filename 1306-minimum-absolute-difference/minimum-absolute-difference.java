class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i < n-1;i++) {
            if(arr[i+1]-arr[i] < minDiff) minDiff = arr[i+1]-arr[i];
        }
        for(int i = 0;i < n-1;i++) {
            if(arr[i+1]-arr[i] == minDiff) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                res.add(list);
            }
        }
        return res;
    }
}