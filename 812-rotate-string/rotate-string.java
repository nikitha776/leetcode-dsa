class Solution {
    public boolean rotateString(String s, String goal) {
        String newStr = s + s;
        return s.length() == goal.length() && newStr.contains(goal);
    }
}