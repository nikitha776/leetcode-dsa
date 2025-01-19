class Solution {
    public void helper(int n,int idx,List<String> list,String str) {
        if(str.length() == n) {
            list.add(str);
            return;
        }
        if(idx == 0 || str.charAt(idx-1) == '1') {
            helper(n,idx+1,list,str+'1');
            helper(n,idx+1,list,str+'0');
        }
        if(idx != 0 && str.charAt(idx-1) == '0') {
            helper(n,idx+1,list,str+'1');
        }
    }
    public List<String> validStrings(int n) {
        List<String> list = new ArrayList<>();
        helper(n,0,list,"");
        return list;
    }
}