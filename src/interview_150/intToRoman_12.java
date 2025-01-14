package interview_150;

import java.util.HashMap;
import java.util.Map;

public class intToRoman_12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
        int[] nums = new int[]{1000, 500, 100, 50, 10, 5, 1};
        int b = 1;
        while (num > 0) {
            int a = num % 10 * b;
            if (map.containsKey(a)) {
                ans.insert(0, map.get(a));
            } else {
                int index = 0;
                StringBuilder str = new StringBuilder();
                while (a > 0) {
                    if (a >= nums[index]) {
                        a = a - nums[index];
                        str.append(map.get(nums[index]));
                    } else {
                        index++;
                    }
                }
                ans.insert(0, str);
            }
            num = num / 10;
            b = b * 10;
        }


        return ans.toString();
    }
}
