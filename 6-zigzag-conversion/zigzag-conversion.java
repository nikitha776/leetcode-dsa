class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int n = s.length();
        int row = 0;
        boolean flag = false;
        ArrayList<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        for(int i = 0;i < n;i++) {
            char ch = s.charAt(i);
            list.get(row).append(ch);
            if(row == numRows-1) {
                row--;
                flag =false;
            } else if(row == 0 && !flag) {
                flag = true;
                row++;
            } else if(flag) {
                row++;
            } else if(!flag) {
                row--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : list) {
            result.append(sb);
        }

        return result.toString();
    }
}

