package Math;

public class 七进制数_504 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
    }
    public static String convertToBase7(int num) {
        StringBuffer str = new StringBuffer();
        int num1 = 0;
        if(num == 0) {
            return "0";
        }
        if(num < 0) {
            num1 = num * -1;
        }else {
            num1 = num;
        }
        while(num1 != 0) {
            int div = num1 % 7;
            str.append(div + "");
            num1 = num1 / 7;
        }
        str = str.reverse();
        int index = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '0') {
                index = i;
                break;
            }
        }
        if(num < 0) {
            String s = str.substring(index,str.length());
            return "-" + s;
        }else {
            return str.substring(index,str.length());
        }
    }
}
