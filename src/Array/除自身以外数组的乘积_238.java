package Array;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class 除自身以外数组的乘积_238 {
    public static void main(String[] args) {
        productExceptSelf(new int[]{1,2,3,4});
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = R * answer[i];
            R = R * nums[i];
        }
        return answer;
    }
}
