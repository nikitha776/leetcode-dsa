class Solution {
    public void helper(int n,int open,int close,List<String> list,String str) {
        if(open == close && open + close == 2*n) {
            list.add(str);
            return;
        }
        if(open < n && close < n && open >= close) {
            helper(n,open+1,close,list,str+'(');
            helper(n,open,close+1,list,str+')');
        }
        if(close <= open && close != n && open == n) {
            helper(n,open,close+1,list,str+')');
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(n,0,0,list,"");
        return list;
    }
}