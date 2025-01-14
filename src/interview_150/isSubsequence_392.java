package interview_150;

public class isSubsequence_392 {
    public static void main(String[] args) {

    }


    public static boolean isSubsequence(String s, String t) {
        int index1 = 0;
        int index2 = 0;
        if (s.length() > t.length()) {
            return false;
        }
        while (index1 < s.length() && index2 < t.length()) {
            while (index1 < s.length() && index2 < t.length() && s.charAt(index1) == t.charAt(index2)) {
                index1++;
                index2++;
            }
            if (index1 == s.length()) {
                return true;
            }
            while (index2 < t.length() && s.charAt(index1) != t.charAt(index2)) {
                index2++;
            }
        }

        return index1 == s.length();
    }
}
