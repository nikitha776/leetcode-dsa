class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i < n;i++) {
            if(asteroids[i] < 0) {
                while(!st.isEmpty() && (st.peek() > 0) && (st.peek() < Math.abs(asteroids[i]))) {
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() > 0 && (st.peek() == Math.abs(asteroids[i]))) {
                    st.pop();
                    continue;
                }
                else if(st.isEmpty() || st.peek() < 0) st.push(asteroids[i]);
            }  else {
                st.push(asteroids[i]);
            }
        }
        int[] res = new int[st.size()];
        int i = st.size() - 1;
        while(!st.isEmpty()) {
            res[i--] = st.pop();
        }
        return res;
    }
}