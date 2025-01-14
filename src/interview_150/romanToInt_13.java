package interview_150;

import java.util.HashMap;
import java.util.Map;

public class romanToInt_13 {
    public static void main(String[] args) {
        String str = "MCMXCIV";
        System.out.println(romanToInt(str));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            String str;
            if (i + 2 <= s.length()) {
                str = s.substring(i, i + 2);
                if (map.get(str) != null) {
                    ans += map.get(str);
                    i = i + 2;
                } else {
                    ans += map.get(str.charAt(0) + "");
                    i++;
                }
            } else {
                str = s.substring(i, i + 1);
                ans += map.get(str.charAt(0) + "");
                i++;
            }

        }

        return ans;
    }
}
