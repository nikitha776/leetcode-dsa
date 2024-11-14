class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // int count = 0;
        // int prevCount = 0;
        // Arrays.sort(arr);
        // for(int i = 0;i < arr.length;i++) {
        //     count  = 0;
        //     if(i > 0 && arr[i] == arr[i-1]) {
        //         continue;
        //     }
        //     for(int j = 0; j < arr.length;j++) {
        //         if(arr[i] == arr[j]) {
        //             count++;
        //         }
        //     }
        //     if(count == prevCount) return false;
        //     else prevCount  = count;
        // }
        // return true;
        int count;
        boolean[] seenCounts = new boolean[1001];  // Track counts encountered (assuming max count <= 1000)
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            // Skip duplicate elements
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            
            // Count occurrences of arr[i]
            count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            
            // Check if this count has already been encountered
            if (seenCounts[count]) {
                return false;  // Duplicate count found
            }
            seenCounts[count] = true;  // Mark this count as encountered
        }
        
        return true;  // All counts are unique
    }
}