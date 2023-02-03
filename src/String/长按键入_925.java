package String;

/**
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 * name = "alex", typed = "aaleex"
 * True
 */
public class 长按键入_925 {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("vtkgn", "vttkgnn"));
    }
    // 双指针，自己写的有些复杂了，但是一开始自己的想法，就把它写下去了，也算通过了，只是效率有点低，但思想是大致一样的
    public static boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) {
            return false;
        }
        if (name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        String temp = "";
        int name_pointer = 0;
        int typed_pointer = 0;
        while (typed_pointer < typed.length()) {
            if (name.charAt(name_pointer) == typed.charAt(typed_pointer)) {
                if (temp.length() != name.length()) {
                    temp += typed.charAt(typed_pointer);
                }
                if (name_pointer < name.length() - 1) {
                    name_pointer++;
                }
                typed_pointer++;
            } else {
                if (typed_pointer - 1 >= 0) {
                    // 如果前一个和当前的不等，代表不是按键重复了
                    if (typed.charAt(typed_pointer) != typed.charAt(typed_pointer - 1)) {
                        return false;
                    }
                }
                // 如果是按键重复的话，就跳过重复的位置，向后移动即可
                while ((typed_pointer < typed.length()) && typed.charAt(typed_pointer) == typed.charAt(typed_pointer - 1)) {
                    typed_pointer++;
                }
            }
        }
        return temp.equals(name);
    }
}
