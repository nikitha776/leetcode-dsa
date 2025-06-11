class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for(int i : nums) {
            set.add(i);
        }

        int longest = 0;

        for(int i : set) {
            if(!set.contains(i-1)) {
                int x = i;
                int count = 1;
                while(set.contains(x+1)) {
                    x++;
                    count++;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
        
    }
}