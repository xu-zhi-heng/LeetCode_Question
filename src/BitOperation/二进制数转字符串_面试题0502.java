package BitOperation;

public class 二进制数转字符串_面试题0502 {
    public static void main(String[] args) {
        System.out.println(printBin(0.1));
    }
    public static String printBin(double num) {
        String result = "0.";
        int count = 0;
        while (num != 0) {
            double temp = num * 2;
            String str = String.valueOf(temp).substring(0, 1);
            if (str.equals("1")) {
                num = temp - 1;
            } else {
                num = temp;
            }
            result = result + str;
            count++;
            if (count > 32) {
                return "ERROR";
            }
        }

        return result;
    }
}
