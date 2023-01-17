package String;

public class 仅仅反转字母_917 {
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
    public static String reverseOnlyLetters(String s) {
        /**
         * 输入：s = "Test1ng-Leet=code-Q!"
         * 输出："Qedo1ct-eeLg=ntse-T!"
         */
        StringBuilder stringBuilder = new StringBuilder(s);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (Character.isLetter(stringBuilder.charAt(left)) && Character.isLetter(stringBuilder.charAt(right))) {
                char temp = s.charAt(left);
                stringBuilder.setCharAt(left, stringBuilder.charAt(right));
                stringBuilder.setCharAt(right, temp);
                left++;
                right--;
            } else if (!Character.isLetter(stringBuilder.charAt(left))) {
                left++;
            } else if (!Character.isLetter(stringBuilder.charAt(right))) {
                right--;
            }
        }
        return stringBuilder.toString();

        // 也可以通过堆栈实现，先进后出，将所有的
    }
}
