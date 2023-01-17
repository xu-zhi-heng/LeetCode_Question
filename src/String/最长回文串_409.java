package String;

import java.util.Scanner;

public class 最长回文串_409 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int i = longestPalindrome(s);
        System.out.println(i);
    }

    public static int longestPalindrome(String s) {
        // 找出可以构成最长回文串的长度
        int[] arr = new int[128];
        for(char c : s.toCharArray()) {
            arr[c]++;
        }
        int count = 0;
        for (int i : arr) {
            count += (i % 2);
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }
}
