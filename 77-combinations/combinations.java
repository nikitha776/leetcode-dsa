class Solution {
    public void helper(int i, List<List<Integer>> res, List<Integer> list, int n,int k) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(i == n+1) {
            return;
        }
        list.add(i);
        helper(i+1,res,list,n,k);
        list.remove(list.size()-1);
        helper(i+1,res,list,n,k);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1,res,new ArrayList<>(),n,k);
        return res;
    }
}