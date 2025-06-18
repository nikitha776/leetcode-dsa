class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        int c1 = 0;
        int c2 = 0;
        int n = nums.length;

        for(int i = 0;i < n;i++) {
            if(c1 == 0 && nums[i] != el2) {
                el1 = nums[i];
                c1++;
            } else if(c2 == 0 && nums[i] != el1) {
                el2 = nums[i];
                c2++;
            } else if(el1 == nums[i]) {
                c1++;
            } else if(el2 == nums[i]) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        List<Integer> list = new ArrayList<>();
        c1 = 0;
        c2 = 0;
        for(int i : nums) {
            if(el1 == i) c1++;
            if(el2 == i) c2++;
        }

        if(c1 > n/3) list.add(el1);
        if(c2 > n/3) list.add(el2);

        return list;
    }
}