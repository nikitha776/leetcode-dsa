class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countL = 0;
        int countR = 0;
        int countDash = 0;
        for(char ch : moves.toCharArray()) {
            if(ch == 'L') countL++;
            else if(ch == 'R') countR++;
            else countDash++;
        }
        return countL > countR ? countL - countR + countDash : countR - countL + countDash;
    }
}