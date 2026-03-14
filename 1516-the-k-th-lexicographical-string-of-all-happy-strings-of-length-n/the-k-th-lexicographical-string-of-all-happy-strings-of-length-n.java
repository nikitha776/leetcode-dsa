class Solution {
    public void helper(List<String> list,StringBuilder str,int n) {
        if(str.length() == n) {
            list.add(str.toString());
            return;
        }
        char last = str.charAt(str.length() - 1);
        if(last == 'a') {
            helper(list,str.append('b'),n);
            str.deleteCharAt(str.length() - 1);
            helper(list,str.append('c'),n);
            str.deleteCharAt(str.length() - 1);
        } 
        if(last == 'b') {
            helper(list,str.append('a'),n);
            str.deleteCharAt(str.length() - 1);
            helper(list,str.append('c'),n);
            str.deleteCharAt(str.length() - 1);
        } 
        if(last == 'c') {
            helper(list,str.append('a'),n);
            str.deleteCharAt(str.length() - 1);
            helper(list,str.append('b'),n);
            str.deleteCharAt(str.length() - 1);
        } 
    }
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        helper(list,new StringBuilder("a"),n);
        helper(list,new StringBuilder("b"),n);
        helper(list,new StringBuilder("c"),n);
        if(list.size() < k) return "";
        return list.get(k-1);
    }
}