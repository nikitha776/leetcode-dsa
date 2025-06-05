class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        // T.C -> O(m+n) 
        // S.C -> O(m+n)
        // HashSet<Integer> set1 = new HashSet<>();
        // HashSet<Integer> set2 = new HashSet<>();
        // ArrayList<Integer> arr = new ArrayList<>();
        // for(int i : nums1) set1.add(i);
        // for(int i : nums2) set2.add(i); 
        // for(int i : set1) {
        //     if(set2.contains(i)) {
        //         arr.add(i);
        //     }
        // }
        // int[] ans = new int[arr.size()];
        // for(int i = 0;i < arr.size();i++) {
        //     ans[i] = arr.get(i);
        // }
        // return ans;

        // T.C -> O(n+m)
        // S.C -> O(n)

        int n = nums1.length;
        int m = nums2.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0;i < n;i++) {
            map.put(nums1[i],1);
        }

        for(int i = 0;i < m;i++)  {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) == 1) {
                list.add(nums2[i]);
                map.put(nums2[i],0);
            }
        }

        int[] res = new int[list.size()];

        int j = 0;
        for(int i : list) {
            res[j++] = i;
        }

        return res;
    }
}