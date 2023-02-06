package String;

public class 最长公共前缀_14 {
    public static void main(String[] args) {
        String[] strings = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;    // 获取数组长度
        if(n == 0) return "";   // 如果数组为空，直接返回“”
        for(int i = 0; i < strs[0].length(); i++) {
            for(int j = 1; j < n; j++) {
                // 以数组的第一个元素为基本，进行比较，依次比较每一个字符，如果出现不同的时候，那么 i 处在的位置，就是重复字符串的位置
                if(strs[j].length() == i || strs[j].charAt(i) != strs[0].charAt(i)) return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
