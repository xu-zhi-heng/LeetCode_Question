package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.regex.Matcher;

/**
 * 给你一个下标从 0 开始的二维整数数组 nums 。一开始你的分数为 0 。你需要执行以下操作直到矩阵变为空：
 *
 * 矩阵中每一行选取最大的一个数，并删除它。如果一行中有多个最大的数，选择任意一个并删除。
 * 在步骤 1 删除的所有数字中找到最大的一个数字，将它添加到你的 分数 中。
 * 请你返回最后的 分数 。
 */
public class 矩阵中的和_2679 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1},
//                {6,4,2},
//                {6,5,3},
//                {3,2,1}
        };
        matrixSum(nums);
    }
    public static int matrixSum(int[][] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }
        for(int j = nums[0].length - 1; j >= 0; j--) {
            int maxNum = Integer.MIN_VALUE;
            // 取的次数
            for(int i = 0; i < nums.length; i++) {
                maxNum = Math.max(maxNum, nums[i][j]);
            }
            sum += maxNum;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
        return sum;
    }
}
