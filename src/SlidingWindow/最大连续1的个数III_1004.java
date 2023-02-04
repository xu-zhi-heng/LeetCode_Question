package SlidingWindow;
/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 *
 * nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 6
 */
public class 最大连续1的个数III_1004 {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }
    public static int longestOnes(int[] nums, int k) {
        int a_pointer = 0;
        int b_pointer = 0;
        while (a_pointer < nums.length) {
            if (nums[a_pointer] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[b_pointer] == 0) {
                    k++;
                }
                b_pointer++;
            }
            a_pointer++;
        }
        return a_pointer - b_pointer;
    }
}
