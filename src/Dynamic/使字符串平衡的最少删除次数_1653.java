package Dynamic;

public class 使字符串平衡的最少删除次数_1653 {
    public static void main(String[] args) {
        minimumDeletions("aababbab");
    }
    // 前后缀分解
    // a 在前缀前， b 在前缀后，枚举每一个分割线，使得 a 在前， b 在后
    public static int minimumDeletions(String s) {
        int min_count = Integer.MAX_VALUE;
        int prefix_b_count = 0;
        int suffix_a_count = 0;
        // 这样写会超时， O(n^2)
//        for (int i = 0; i <= s.length(); i++) {
//            prefix_b_count = 0;
//            suffix_a_count = 0;
//            // 统计当前分割线后 a 的个数
//            for (int j = i; j < s.length(); j++) {
//                if (s.charAt(j) == 'a') {
//                    suffix_a_count++;
//                }
//            }
//            // 统计当前分割线前 b 的个数
//            for (int k = 0; k < i; k++) {
//                if (s.charAt(k) == 'b') {
//                    prefix_b_count++;
//                }
//            }
//            min_count = Math.min(min_count, prefix_b_count + suffix_a_count);
//        }
        // 先统计出所有 a 的个数
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                suffix_a_count++;
            }
        }
        // 首先，思想和上面一样，要删除分割线 前面b的个数和分割线后面a的个数
        // 如果当前的位置是 a, 那么suffix_a_count - 1, 这样代表分割线后面a的个数还有多少
        // 类似于动态处理
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                suffix_a_count--;
            }
            min_count = Math.min(min_count, suffix_a_count + prefix_b_count);
            if (s.charAt(i) == 'b') {
                prefix_b_count++;
            }
        }
        return min_count;
    }


    // 动态规划
    public static int minimumDeletionsByDP(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        int b_count = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == 'b') {
                // 因为满足平衡，代表b都是在最后的，所有如果当前是b，前面的状态就是当前的状态，不需要改变
                dp[i] = dp[i - 1];
                b_count++;
            } else {
                // 如果当前是 a， 两种处理，删除当前的a 和 删除当前之前所有的a, 取最小次数
                dp[i] = Math.min(b_count, dp[i - 1] + 1);
            }
        }
        return dp[s.length()];
    }
}
