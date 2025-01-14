package interview_150;

public class reverseWords_151 {
    public static void main(String[] args) {
        String str = "a good   example";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        s = s.trim();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ' && temp.length() > 0) {
                str.append(temp.reverse());
                str.append(" ");
                temp = new StringBuilder();
            } else if (s.charAt(i) != ' '){
                temp.append(s.charAt(i) + "");
            }
        }
        str.append(temp.reverse());
        return str.toString();
    }
}
