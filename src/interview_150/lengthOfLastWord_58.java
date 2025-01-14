package interview_150;

public class lengthOfLastWord_58 {

    public static void main(String[] args) {
        String s = "Today is a nice day";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int ans = 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return count;
            } else {
                count++;
            }
        }
        return ans;
    }

}
