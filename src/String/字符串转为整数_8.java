package String;

import java.util.Scanner;

/**
 * 第8题
 *
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 *
 */
public class 字符串转为整数_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int i = myAtoi(s);
        System.out.println(i);
    }
    public static int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) {
            return 0;
        }
        if(s.charAt(0) == '.' || (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') || s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
            return 0;
        }
        int flag = 0;
        if(!(s.charAt(0) != '+' && s.charAt(0) != '-')) {
            flag = s.charAt(0) == '+' ? 1 : -1;
        }
        double result = 0.0;
        double decimal = 0.0;
        double x = 0.1;
        boolean isDecimal = true;
        for(int i = flag != 0 ? 1 : 0; i < s.length(); i++) {
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || s.charAt(i) == ' ' || s.charAt(i) == '-' || s.charAt(i) == '+') {
                break;
            }else if(s.charAt(i) == '.') {
                if(!Character.isDigit(s.charAt(i + 1))) {
                    break;
                }else {
                    isDecimal = false;
                    i++;
                }
            }
            int number = Integer.parseInt(s.substring(i, i + 1));
            if(isDecimal) {
                result = result * 10 +  number;
            }else {
                decimal = number * x + decimal;
                x = x * 0.1;
            }
        }
        if(flag == 0 || flag == 1) {
            flag = 1;
        }else {
            flag = -1;
        }
        result = (result + decimal) * flag;
        if(result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }else if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }else {
            return (int) result;
        }
    }
}
