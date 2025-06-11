class Solution {
    public int longestConsecutive(int[] nums) {
        // int n = nums.length;
        // if(n == 0) return 0;
        // HashSet<Integer> set = new HashSet<>();

        // for(int i : nums) {
        //     set.add(i);
        // }

        // int longest = 0;

        // for(int i : nums) {
        //     if(!set.contains(i-1)) {
        //         int x = i;
        //         int count = 1;
        //         while(set.contains(x+1)) {
        //             x++;
        //             count++;
        //         }
        //         longest = Math.max(longest,count);
        //     }
        // }
        // return longest;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }
}