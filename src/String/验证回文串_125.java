package String;

public class 验证回文串_125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        if (s.trim().equals("")) {
            return true;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))) {
                temp.append((s.charAt(i) + "").toLowerCase());
            }
        }
        System.out.println(temp);

        int left = 0;
        int right = temp.length() - 1;

        while (left < right) {
            if (temp.charAt(left) != temp.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }
}
