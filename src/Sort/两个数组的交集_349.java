package Sort;

import java.util.*;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class 两个数组的交集_349 {
    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        System.out.println(Arrays.toString(intersection2(num1, num2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                    break;
                }
            }
        }
        Object[] obj = set.toArray();
        int temp[] = new int[obj.length];
        for (int i = 0; i < obj.length; i++) {
            temp[i] = (int) obj[i];
            System.out.print(temp[i] + " ");
        }
        return temp;
    }

    // 通过排序加双指针完成
    public static int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            }else {
                if(nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        Object[] obj = set.toArray();
        int temp[] = new int[obj.length];
        for (int k = 0; k < obj.length; k++) {
            temp[k] = (int) obj[k];
        }
        return temp;
    }
}
