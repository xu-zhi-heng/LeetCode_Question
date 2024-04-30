package String;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman_12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(20));
    }

    public static String intToRoman(int num) {
        HashMap<String, Integer> hash = new LinkedHashMap<>();
        StringBuilder result = new StringBuilder();
        hash.put("M", 1000);
        hash.put("CM", 900);
        hash.put("D", 500);
        hash.put("CD", 400);
        hash.put("C", 100);
        hash.put("XC", 90);
        hash.put("L", 50);
        hash.put("XL", 40);
        hash.put("X", 10);
        hash.put("IX", 9);
        hash.put("V", 5);
        hash.put("IV", 4);
        hash.put("I", 1);
        while (num > 0) {
            for (Map.Entry<String, Integer> entry : hash.entrySet()) {
                if (num >= entry.getValue()) {
                    num = num - entry.getValue();
                    result.append(entry.getKey());
                    break;
                }
            }
        }
        return result.toString();
    }
}
