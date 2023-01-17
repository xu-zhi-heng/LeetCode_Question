package String;
/**
 * 第五题
 */
public class 最长回文子串_5 {
    public static void main(String[] args) {
        String str = longestPalindrome("abcba");
        System.out.println(str);
    }

    /**
     * 暴力解法
     * 思路： 遍历出每一个子串，然后判断该子串是否为回文，记录长度并比较长度大小
     */
    public static String longestPalindrome(String s) {
        int len = 0;
        String str = "";
        for(int i = 0; i <= s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                if(isPalindrome(s.substring(i, j))) {
                    int length = s.substring(i, j).length();
                    if(length > len) {
                        len = length;
                        str = s.substring(i, j);
                    }
                }
            }
        }
        if(str.equals("")) {
            return null;
        }
        return str;
    }

    /**
     * 动态规划
     */
//    public static String longestPalindrome2(String s) {
//        if(s.length() == 1) {
//            return s;
//        }
//        if(s.length() == 2 && s.charAt(0) == s.charAt(1)) {
//            return s;
//        }
//        int[][] dp = new int[s.length()][s.length()];
//        dp[0][0] = 1;
//        String str = "";
//    }



    /**
     * 判断是否为回文数
     */
    public static boolean isPalindrome(String s) {
        // 第一种
//        StringBuilder stringBuilder = new StringBuilder(s);
//        return stringBuilder.reverse().toString().equals(s);

        // 第二种
        int length = s.length();
        int middle = length / 2;
        boolean flag = true;
        for(int i = 0; i < middle; i++) {
            if(s.charAt(i) != s.charAt(length - i - 1)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
