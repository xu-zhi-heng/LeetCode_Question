package Greedy;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 *
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 *
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 */

public class 递减元素使数组呈锯齿状_1144 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        // 改变temp， nums不会变化
//        int[] temp = Arrays.copyOf(nums, nums.length);
//        System.out.println(Arrays.toString(temp));
//        temp[0] = 4;
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(temp));
//        temp = Arrays.copyOf(nums, nums.length);
//        System.out.println(Arrays.toString(temp));
        movesToMakeZigzag(nums);
    }
    // 分别遍历一次偶数和奇数的情况即可
    public static int movesToMakeZigzag(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] temp = Arrays.copyOf(nums, nums.length);
        int evenCount = 0;
        for (int even = 0; even < nums.length; even = even + 2) {
            if (even == 0) {
                while (temp[0] <= temp[1]) {
                    temp[1]--;
                    evenCount++;
                }
            } else if (even == nums.length - 1) {
                while (temp[even] <= temp[even - 1]) {
                    temp[even - 1]--;
                    evenCount++;
                }
            } else {
                while (temp[even] <= temp[even + 1]) {
                    temp[even + 1]--;
                    evenCount++;
                }
                while (temp[even] <= temp[even - 1]) {
                    temp[even - 1]--;
                    evenCount++;
                }
            }
        }
        temp = Arrays.copyOf(nums, nums.length);
        int oddCount = 0;
        for (int odd = 1; odd < nums.length; odd = odd + 2) {
            if (odd == nums.length - 1) {
                while (temp[odd] <= temp[odd - 1]) {
                    temp[odd - 1]--;
                    oddCount++;
                }
            } else {
                while (temp[odd] <= temp[odd - 1]) {
                    temp[odd - 1]--;
                    oddCount++;
                }
                while (temp[odd] <= temp[odd + 1]) {
                    temp[odd + 1]--;
                    oddCount++;
                }
            }
        }

        System.out.println(evenCount);
        System.out.println(oddCount);

        return Math.min(oddCount, evenCount);
    }
}
