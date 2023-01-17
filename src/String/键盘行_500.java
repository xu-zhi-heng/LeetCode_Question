package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 键盘行_500 {
    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(findWords(words)));
    }
    public static String[] findWords(String[] words) {
        List<String> str = new ArrayList<String>();
        String[] s = {"qwertyuiop","asdfghjkl","zxcvbnm"};
        for(String word : words) {
            String result = word.toLowerCase();
            for(int i = 0; i < s.length; i++) {
                boolean flag = check(result,s[i]);
                if(flag) {
                    str.add(word);
                }
            }
        }
        String[] strings = new String[str.size()];
        return str.toArray(strings);
    }
    public static boolean check(String result,String s) {
        for(int i = 0; i < result.length(); i++) {
            if(s.indexOf(result.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
}
