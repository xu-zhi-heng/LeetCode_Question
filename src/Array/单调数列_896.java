package Array;

public class 单调数列_896 {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{6, 5, 4, 4}));
    }
    public static boolean isMonotonic(int[] nums) {
        boolean dec = true;
        boolean desc = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                desc = false;
            }
            if (nums[i + 1] < nums[i]) {
                dec = false;
            }
        }
        return dec || desc;
    }
}
