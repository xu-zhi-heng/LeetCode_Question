package Array;

import java.util.Arrays;

public class 加一_66 {
    public static void main(String[] args) {
        int[] digits = new int[]{1,2,3};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        // 从末尾开始加 1， 如果 加 1 后 大于 10 需要进位， 如果不需要进位就直接返回
        for(int i = digits.length - 1; i >= 0; i--){
            digits[i]++;
            digits[i] %= 10;
            if(digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
