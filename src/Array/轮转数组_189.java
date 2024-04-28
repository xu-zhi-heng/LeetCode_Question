package Array;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class 轮转数组_189 {


    public static void main(String[] args) {
        test(new int[]{1,2,3,4,5,6,7}, 3);
    }


    public static void test(int[] nums, int k) {
        // 超时
//        int len = nums.length;
//        while(k > 0) {
//            int last = nums[len - 1];
//            for(int i = len - 2; i >= 0; i--) {
//                nums[i + 1] = nums[i];
//            }
//            nums[0] = last;
//            k--;
//        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            queue.add(nums[i]);
        }
        while (k > 0) {
            Integer remove = queue.remove();
            queue.add(remove);
            k--;
        }
        int index = nums.length - 1;
        while (queue.size() != 0) {
            nums[index--] = queue.remove();
        }
    }
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
