package BitOperation;

public class 数字的补数_464 {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement2(num));
    }
    public static int findComplement(int num) {
        StringBuffer stringBuffer = new StringBuffer();
        while(num != 0) {
            int bit = num % 2;
            stringBuffer.append(bit);
            num = num / 2;
        }
        stringBuffer = stringBuffer.reverse();
        for(int i = 0; i < stringBuffer.length(); i++) {
            if(stringBuffer.charAt(i) == '0') {
                stringBuffer.replace(i,i + 1,"1");
            }else {
                stringBuffer.replace(i,i + 1,"0");
            }
        }
        String s = stringBuffer.toString();
        int index = s.indexOf("1");
        if(index == -1) {
            return 0;
        }
        String str = "";
        for(int i = index; i < s.length(); i++) {
            str += s.charAt(i) + "";
        }
        System.out.println(str.length());
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            sum = sum * 2 + Integer.parseInt(str.charAt(i) + "");
        }
        return sum;
    }
    public static int findComplement2(int num) {
        String str = Integer.toBinaryString(num);
        int len  = str.length();
        String bit = "";
        for(int i = 0; i < len; i++) {
           bit += "1";
        }
        int result = 0;
        for(int i = 0; i < bit.length(); i++) {
            result = result * 2 + Integer.parseInt(bit.charAt(i) + "");
        }
        return result ^ num;
    }
}
