package String;
/**
 * 我们要把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为100个单位，如果我们在写某个字母的时候会使这行超过了100 个单位，
 * 那么我们应该把这个字母写到下一行。我们给定了一个数组 widths ，这个数组 widths[0] 代表 'a' 需要的单位，
 * widths[1] 代表 'b' 需要的单位，...， widths[25] 代表 'z' 需要的单位。
 *
 * 现在回答两个问题：至少多少行能放下S，以及最后一行使用的宽度是多少个单位？将你的答案作为长度为2的整数列表返回。
 */
public class 写字符串需要的行数_806 {
    public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        int space = 100;
        int row = 1;
        for (int i = 0; i < s.length(); i++) {
            if (space < widths[s.charAt(i) - 'a']) {
                space = 100;
                row++;
            }
            space = space - widths[s.charAt(i) - 'a'];
        }
        result[0] = row;
        result[1] = 100 - space;
        return result;
    }
}
