package String;

public class 比较含退格的字符串_844 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab##", "c#d#"));
    }

    public static boolean backspaceCompare(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        while (s.contains("#")) {
            int index = s.indexOf("#");
            if (index == 0) {
                s = s.substring(1, s.length());
            } else {
                s = s.substring(0, index - 1) + s.substring(index + 1, s.length());
            }
        }
        while (t.contains("#")) {
            int index = t.indexOf("#");
            if (index == 0) {
                t = t.substring(1, t.length());
            } else {
                t = t.substring(0, index - 1) + t.substring(index + 1, t.length());
            }
        }
        if (s.equals(t)) {
            return true;
        }
        return false;
    }
}
