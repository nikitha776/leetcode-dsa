class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0;i < n;i++) {
            if(count1 == 0 && nums[i] != el2) {
                el1 = nums[i];
                count1++;
            } else if(count2 == 0 && nums[i] != el1) {
                el2 = nums[i];
                count2++;
            } else if(el1 == nums[i]) {
                count1++;
            } else if(el2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> list = new ArrayList<>();
        int c1 = 0;
        int c2 = 0;
        for(int i : nums) {
            if(i == el1) c1++;
            else if(i == el2) c2++;
        }
        if(c1 > n/3) list.add(el1);
        if(c2 > n/3) list.add(el2);
        return list;
    }
}