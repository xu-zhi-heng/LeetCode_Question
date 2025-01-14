package interview_150;

public class longestCommonPrefix_14 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] strs = new String[]{"flower","flow","flight"};
        for (String str : strs) {
            trie.insert(str);
        }
        System.out.println(trie.getLongestCommonPrefix());
    }

}

class TrieNode {
    boolean isWord;
    TrieNode[] children;

    public TrieNode() {
        this.isWord = false;
        this.children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isWord;
    }

    // 判断一个单词word是否是字典树中的前缀
    public boolean startsWith(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                return false;
            }
            cur = cur.children[c];
        }
        return true;
    }

    public String getLongestCommonPrefix() {
        TrieNode current = root;
        StringBuilder prefix = new StringBuilder();
        while (current != null) {
            int count = 0;
            TrieNode nextNode = null;
            char nextChar = ' ';
            for (int i = 0; i < 26; i++) {
                if (current.children[i] != null) {
                    count++;
                    nextChar = (char)(i + 'a');
                    nextNode = current.children[i];
                }
            }
            if (count != 1 || current.isWord) {
                break;
            }
            prefix.append(nextChar);
            current = nextNode;
        }

        return prefix.toString();
    }


}



