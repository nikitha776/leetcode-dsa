class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < arr.length;i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        List<Integer> freqs = new ArrayList<>(map.values());
        Collections.sort(freqs);
        int count = 0;
        for(int i = 0;i < freqs.size();i++) {
            count += freqs.get(i);
            if(count > k) {
                return freqs.size()-i;
            }
        }
        return 0;
    }
}