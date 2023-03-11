package Dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 单词拆分_139 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("bc");
        list.add("cb");
        System.out.println(wordBreak("ccbb", list));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        return dp(s, new HashMap<>(), wordDict);
    }

    public static boolean dp(String target, HashMap<String, Boolean> memory, List<String> wordDict) {
        if (memory.containsKey(target)) {
            return memory.get(target);
        }
        if (target.equals("")) {
            return true;
        }
        for (String word : wordDict) {
            if (target.contains(word)) {
                target = target.replaceAll(word, "");
                if (dp(target, memory, wordDict)) {
                    memory.put(target, true);
                    return true;
                }
            }
        }
        memory.put(target, false);
        return false;
    }
}
