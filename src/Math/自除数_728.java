package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数整除的数。
 *
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 *
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 */
public class 自除数_728 {
    public static void main(String[] args) {
        selfDividingNumbers(1, 22);
    }
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }
    public static boolean isSelfDividingNumber(int num) {
        int temp = num;
        while (num != 0) {
            if (num % 10 == 0) {
                return false;
            }
            if (temp % (num % 10) != 0) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }
}
