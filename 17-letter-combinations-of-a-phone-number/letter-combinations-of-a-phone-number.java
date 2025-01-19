class Solution {
    public void helper(List<String> ans,String str,String digits,HashMap<Character,String> map,int idx) {
        if(idx == digits.length()) {
            ans.add(str);
            return;
        }
        char ch = digits.charAt(idx);
        for(int i = 0;i < map.get(ch).length();i++) {
            helper(ans,str + map.get(ch).charAt(i),digits,map,idx+1);
        }
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;
        helper(ans,"",digits,map,0);
        return ans;
    }
}