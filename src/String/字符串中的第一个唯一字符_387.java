package String;

public class 字符串中的第一个唯一字符_387 {
    public static int firstUniqChar(String s) {
        int[] caps = new int[26];
        int[] index = new int[s.length()];
        int sum = 0;
        for(char c : s.toCharArray()) {
            caps[c - 97] = caps[c - 97] + 1;
            index[sum++] = c - 97;
        }
        for(int i = 0; i < s.length(); i++) {
            if(caps[index[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int leetcode = firstUniqChar("leetcode");
        System.out.println(leetcode);
    }
}
