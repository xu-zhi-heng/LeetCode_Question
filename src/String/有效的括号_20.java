package String;

import java.util.Arrays;

public class 有效的括号_20 {
    public static void main(String[] args) {
        boolean valid = isValid("()");
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }
        String[] str = new String[]{"(",")","[","]","{","}"};
        int len = s.length();
        for(int i = 0; i < len / 2; i++) {
            int index1 = Arrays.binarySearch(str, s.charAt(i) + "");
            int index2 = Arrays.binarySearch(str, s.charAt(len - 1 - i) + "");
            if(index2 - index1 != 1) {
                return false;
            }
        }
        return true;
    }
}
