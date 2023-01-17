package String;

public class 重复的子字符串_459 {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(repeatedSubstringPattern(s));
    }
    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = 1; i < len; i++) {
            if(len % i == 0) {
                boolean flag  = true;
                String str = s.substring(0, i);
                for(int j = i; j + i <= len; j = j + i) {
                    String test = s.substring(j, j + i);
                    if(!str.equals(test)) {
                        flag = false;
                       break;
                    }
                }
                if(flag) {
                    return flag;
                }
            }
        }
        return false;
    }
}
