class Solution {
    public int maximum69Number (int num) {
        int res = 0;
        int temp = num;
        List<Integer> list = new ArrayList<>();
        while(temp > 0) {
            int r = temp % 10;
            list.add(0,r);
            temp = temp/10;
        }
        boolean flag = false;
        for(int i : list) {
            if(i == 6 && !flag) {
                res = res*10 + 9;
                flag = true;
            } else {
                res = res*10 + i;
            }
        }
        return res;
    }
}