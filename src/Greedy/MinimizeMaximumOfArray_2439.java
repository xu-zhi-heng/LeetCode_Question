package Greedy;

public class MinimizeMaximumOfArray_2439 {
    public static void main(String[] args) {
        System.out.println(minimizeArrayValue(new int[]{13,13,20,0,8,9,9}));
    }


    public static int minimizeArrayValue(int[] nums) {
        long total = 0;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            long middle = total % (i + 1) == 0 ? total / (i + 1) : total / (i + 1) + 1;
            res = Math.max(res, middle);
        }
        return (int) res;
    }
}
