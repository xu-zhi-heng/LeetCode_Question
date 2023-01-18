package String;
import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
 */
public class 查找共用字符_1002 {
    public List<String> commonChars(String[] words) {
        // 以数组中的第一个字符串为基础，依次取出每一个字符，看另外数组的元素是否包含此元素，如果都有，就添加到list中，边比较边将元素从字符串中去除，避免重复
        List<String> result = new ArrayList<>();
        String firstWord = words[0];
        for (int i = 0; i < firstWord.length(); i++) {
            String s =  firstWord.charAt(i) + "";
            int j;
            for (j = 1; j < words.length; j++) {
                StringBuilder temp = new StringBuilder(words[j]);
                if (temp.indexOf(s) == -1) {
                    break;
                } else {
                    int index = temp.indexOf(s);
                    words[j] = String.valueOf(temp.replace(index, index + 1, ""));
                }
            }
            if (j == words.length) {
                result.add(s);
            }
        }
        return result;
    }
}
