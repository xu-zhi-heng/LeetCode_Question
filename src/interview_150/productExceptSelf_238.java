package interview_150;

import java.util.Arrays;

public class productExceptSelf_238 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }

    public static int[] productExceptSelf(int[] nums) {
        // 前缀之积 * 后缀之积 = 除去当前元素外所以元素的乘积

        // 表示数组的前缀之积
        int[] left = new int[nums.length];

        // 为什么初始为1：因为第一个元素前缀没有元素，那么第一个元素除去当前元素外所以元素的乘积 = 后缀元素之积 * 前缀之积
        // 第一个元素的后置就积就等于第一个元素除去当前元素外所以元素的乘积, 所以第一个元素的前缀之积为1
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}
