class Solution {
    // public void helper(int[] nums,List<Integer> list,List<List<Integer>> lists,int[] freq) {
    //     if(list.size() == nums.length) {
    //         lists.add(new ArrayList<>(list));
    //         return;
    //     }
    //     for(int i = 0;i < nums.length;i++) {
    //         if(freq[i] == 0) {
    //             freq[i] = 1;
    //             list.add(nums[i]);
    //             helper(nums,list,lists,freq);
    //             list.remove(list.size()-1);
    //             freq[i] = 0;
    //         }
    //     }
    // }

    public void helper(int[] nums,List<List<Integer>> ans,int idx) {
        if(idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < nums.length;i++) {
                list.add(nums[i]);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx;i < nums.length;i++) {
            swap(i,idx,nums);
            helper(nums,ans,idx+1);
            swap(i,idx,nums);
        }
    }

    public void swap(int a,int b,int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] freq = new int[nums.length];
        // helper(nums,list,lists,freq);
        helper(nums,lists,0);
        return lists;
    }
}