package Dynamic;

import java.util.HashMap;

public class UncrossedLines_1035 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,4,2};
        int[] nums2 = new int[]{1,2,4};
        maxUncrossedLines(nums1, nums2);
    }


    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        return dfs(0, 0, nums1, nums2, new HashMap<>());
    }


    public static int dfs(int i, int j, int[] nums1, int[] nums2, HashMap<String, Integer> memory) {
        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }
        if (memory.containsKey(i + "," + j)) {
            return memory.get(i + "," + j);
        }
        if (nums1[i] == nums2[j]) {
            memory.put(i + "," + j, 1 + dfs(i + 1, j + 1, nums1, nums2, memory)) ;
        } else {
            memory.put(i + "," + j, Math.max(dfs(i + 1, j, nums1, nums2, memory), dfs(i, j + 1, nums1, nums2, memory)));
        }
        return memory.get(i + "," + j);
    }
}
