package String;

import java.util.Arrays;

public class ReverseWordsInString_151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        String[] s1 = s.split(" ");
        int left = 0;
        int right = s1.length - 1;
        while (left < right) {
            if (s1[left].isEmpty()) {
                left++;
            }
            if (s1[right].isEmpty()) {
                right--;
            }
            String temp = s1[left];
            s1[left] = s1[right];
            s1[right] = temp;
            left++;
            right--;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            if (!s1[i].isEmpty()) {
                result.append(s1[i] + " ");
            }
        }
        return result.toString().trim();
    }
}
