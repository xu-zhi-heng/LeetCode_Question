package interview_150;

import java.util.ArrayList;
import java.util.List;

public class fullJustify_68 {

    public static void main(String[] args) {

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int[] count = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            count[i] = words[i].length();
        }
        List<String> result = new ArrayList<>();
        int total = 0;
        int startIndex = 0;
        for (int i = 0; i < words.length; i++) {
            total = total + count[i] + 1;
            if (total - 1 > maxWidth) {
                StringBuilder string = new StringBuilder();
                int size = words[startIndex].length() + words[i - 1].length();
                int remind = maxWidth - size - 1;
                for (int j = startIndex; j < i - 1; j++) {
                    string.append(words[j]);
                }
                total = count[i];
                startIndex = i;
            }
        }


        return result;
    }
}
