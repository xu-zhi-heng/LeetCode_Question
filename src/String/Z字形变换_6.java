package String;

import java.util.Arrays;

public class Z字形变换_6 {
    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {
        String[] res = new String[numRows];
        int index = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (res[index] == null) {
                res[index] = s.charAt(i) + "";
            } else {
                res[index] += s.charAt(i) + "";
            }
            if (flag) {
                index++;
            } else {
                index--;
            }
            if (index == 0) {
                flag = true;
            } else if (index == numRows - 1) {
                flag = false;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < res.length; i++) {
            if (res[i] != null) {
                stringBuilder.append(res[i]);
            }
        }
        return stringBuilder.toString();
    }
}
