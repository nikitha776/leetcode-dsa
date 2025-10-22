class Solution {
    public void helper(int i,List<List<Integer>> res,List<Integer> list,int target,int k) {
        if(list.size() == k) {
            if(target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if(target < 0 || i == 10) return;
        list.add(i);
        helper(i+1,res,list,target-i,k);
        list.remove(list.size()-1);
        helper(i+1,res,list,target,k);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1,res,new ArrayList<>(),n,k);
        return res;
    }
}