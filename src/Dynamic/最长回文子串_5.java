package Dynamic;
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

    /**
     * 动态规划
     */
    public String longestPalindromeByDP(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 此处的 L 只字符串的长度, 从 2 开始， 因为 1 位字符串肯定是回文
        for (int L = 2; L <= len; L++) {
            // i 指的是左边界
            for (int i = 0; i < len; i++) {
                // j 指的是右边界:  j - i + 1 = L
                int j = L + i - 1;

                if (j >= len) {
                    break;
                }

                if (s.charAt(i) == s.charAt(j)) {
                    // 但最左边和最右边的字符相等时，且字符的长度不超过三位，那么肯定时回文
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 根据递推的条件可以知道，如果一个子字符串是回文，那么左边界和右边界同时扩展一位，且扩展一位的那个两个字符野相等，那么必然是回文
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }
}
