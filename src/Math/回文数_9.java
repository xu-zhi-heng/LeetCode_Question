package Math;

public class 回文数_9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int number = x;
        int result = 0;
        while(x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result == number;
    }
}
