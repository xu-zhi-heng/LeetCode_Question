package interview_150;

public class isPalindrome_125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(".,"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
