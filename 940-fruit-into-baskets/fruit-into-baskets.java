class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int n = fruits.length;

        while(right < n) {
            int num = fruits[right];
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.size() <= 2) {
                maxLen = Math.max(maxLen,right-left+1);
            } else {
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left]) <= 0) map.remove(fruits[left]);
                left++;
            }
            right++;
        }
        return maxLen;
    }
}