package interview_150;

public class rotate_189 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;



        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        int size = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, size - 1);
        reverse(nums, size, nums.length - 1);

        // 超时
//        for (int i = 0; i < k % nums.length; i++) {
//            int last = nums[nums.length - 1];
//            for (int j = nums.length - 2; j >= 0; j--) {
//                nums[j + 1] = nums[j];
//            }
//            nums[0] = last;
//        }
    }

    public static void reverse(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            int temp = nums[i];
            nums[i] = nums[end];
            nums[end] = temp;
            end--;
        }
    }
}
