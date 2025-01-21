class Solution {
    public boolean isPalindrome(String str,int start,int end) {
        while(start <= end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public void helper(String s,List<List<String>> res,List<String> path,int idx) {
        if(idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = idx;i < s.length();i++) {
            if(isPalindrome(s,idx,i)) {
                path.add(s.substring(idx,i+1));
                helper(s,res,path,i+1);
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s,ans,new ArrayList<>(),0);
        return ans;
    }
}