package DFS;

public class ImplementMagicDictionary_676 {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello","hallo","leetcode","judge"});
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hallo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcodd"));
        System.out.println(magicDictionary.search("judge"));
    }
}


class MagicDictionary {

    private String[] dictionary;
    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public boolean search(String searchWord) {
        boolean flag = false;
        for (int i = 0; i < dictionary.length; i++) {
            if (!dictionary[i].equals(searchWord) && dictionary[i].length() == searchWord.length()) {
                flag = dfs(dictionary[i], searchWord, 1, 0, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(String str1, String str2, int count, int i, int j) {
        if (i >= str1.length() && j >= str2.length()) {
            return true;
        }
        if (str1.charAt(i) != str2.charAt(j)) {
            if (count > 0) {
                return dfs(str1, str2, count - 1, i + 1, j + 1);
            } else {
                return false;
            }
        } else {
            return dfs(str1, str2, count, i + 1, j + 1);
        }
    }
}