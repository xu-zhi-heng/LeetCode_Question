package String;

import java.util.ArrayList;
import java.util.List;

public class 唯一摩尔斯密码词_804 {

    public int uniqueMorseRepresentations(String[] words) {
        String[] str = new String[]{
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        List<String> list = new ArrayList<>();
        for (String word : words) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i <  word.length(); i++) {
                temp.append(str[word.charAt(i) - 97]);
            }
            if (!list.contains(String.valueOf(temp))) {
                list.add(String.valueOf(temp));
            }
        }
        return list.size();
    }

}
