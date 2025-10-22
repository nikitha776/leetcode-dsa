class Solution {
    public void helper( HashMap<Character,String> map, String s, String digits, int idx, List<String> res) {
        if(idx == digits.length()) {
            res.add(s);
            return;
        }
        char t = digits.charAt(idx);
        for(char i : map.get(t).toCharArray()) {
            helper(map,s+i,digits,idx+1,res);
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
        List<String> res = new ArrayList<>();
        helper(map,"",digits,0,res);
        return res;
    }
}