package String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 *
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 *
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 */
public class 字符的最短距离_821 {
    public int[] shortestToChar(String s, char c) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, 0);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                list.add(i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                int dis = Integer.MAX_VALUE;
                for (Integer value : list) {
                    if (Math.abs(value - i) < dis) {
                        dis = Math.abs(value - i);
                    }
                }
                answer[i] = dis;
            }
        }
        return answer;
    }
}
