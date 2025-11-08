class Solution {
    public boolean check(int[] nums,int l,int r) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int i = l;i <= r;i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
            set.add(nums[i]);
        }
        if((max - min) % (r-l) != 0) return false;
        int diff = (max - min) / (r - l);
        int curr = min+diff;
        while(curr < max) {
            if(!set.contains(curr)) return false;
            curr += diff;
        }
        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for(int i = 0;i < l.length;i++) {
            if(check(nums,l[i],r[i])) res.add(true);
            else res.add(false);
        }
        return res;
    }
}