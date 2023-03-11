package SlidingWindow;
/**
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
 *
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 *
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 *
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 */
public class 得到K个黑块的最少涂色次数_2379 {
    public static void main(String[] args) {
        System.out.println(minimumRecolors("BWWWBB", 6));
    }
    public static int minimumRecolors(String blocks, int k) {
        int minCount = blocks.length();
        int right = 0;
        // 每次截取 k 个字符作为窗口
        for (int left = 0; left <= blocks.length() - k; left++) {
            int count = 0;
            right = left + k;
            String str = blocks.substring(left, right);
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'W') {
                    count++;
                }
            }
            minCount = Math.min(minCount, count);
        }
        return minCount;
    }
}
