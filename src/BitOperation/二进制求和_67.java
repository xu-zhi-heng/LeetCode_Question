package BitOperation;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 */
public class 二进制求和_67 {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        int temp = 0;
        while (i >= 0 || j >= 0) {
            int num1 = i >= 0 ? Character.getNumericValue(a.charAt(i)) : 0;
            int num2 = j >= 0 ? Character.getNumericValue(b.charAt(j)) : 0;
            stringBuilder.append((num1 + num2 + temp) % 2);
            temp = (num1 + num2 + temp) / 2;
            i--;
            j--;
        }
        if (temp != 0) {
            stringBuilder.append("1");
        }
        return stringBuilder.reverse().toString();
    }
}
