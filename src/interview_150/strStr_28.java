package interview_150;

public class strStr_28 {

    public static void main(String[] args) {

    }



    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            // 相等的情况下
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        for (int index1 = 0, index2 = 0; index1 < haystack.length(); index1++) {
            while (index2 > 0 && haystack.charAt(index1) != needle.charAt(index2)) {
                index2 = next[index2 - 1];
            }
            if (haystack.charAt(index1) == needle.charAt(index2)) {
                index2++;
            }
            if (index2 == needle.length()) {
                return index1 - index2 + 1;
            }
        }
        return -1;
    }
}
