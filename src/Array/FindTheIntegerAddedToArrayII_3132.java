package Array;

import java.util.Arrays;

public class FindTheIntegerAddedToArrayII_3132 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,6,3,1,4,2,10,9,5};
        int[] nums2 = new int[]{5,10,3,2,6,1,9};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(minimumAddedInteger(nums1, nums2));
    }

    public static int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int x = nums2[0] - nums1[i];
            if (isEqual(nums1, nums2, x)) {
                ans = Math.min(ans, x);
            }
        }
        return ans;
    }
    public static boolean isEqual(int[] nums1, int[] nums2, int x) {
        int i = 0;
        int j = 0;
        int count = 2;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] + x == nums2[j]) {
                j++;
            } else {
                count--;
            }
            i++;
        }
        return count >= 0;
    }
}
