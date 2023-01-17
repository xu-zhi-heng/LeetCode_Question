package String;

public class 检测大写字母_520 {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("FlaG"));
    }
    public static boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;
        int flag = isCase(word.charAt(0)) ? 1 : 0;
        if(flag == 1) {
            if(isCase(word.charAt(1))) {
                if(!isUppercase(flag,word)) return false;
                return true;
            }else {
                flag = 0;
                if(!isUppercase(flag,word)) return false;
                return true;
            }
        }else {
            if(isCase(word.charAt(1))) return false;
            if(!isUppercase(flag,word)) return false;
            return true;
        }
    }

    public static boolean isCase(char c) {
        if(c >= 65 && c <= 90) {
            return true;
        }else {
            return false;
        }
    }

    public static boolean isUppercase(int flag,String word) {
        if(flag == 1) {
            for(int i = 2; i < word.length(); i++) {
                if(!isCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }else {
            for(int i = 2; i < word.length(); i++) {
                if(isCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
