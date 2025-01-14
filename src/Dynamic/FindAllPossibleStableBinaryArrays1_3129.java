package Dynamic;

import java.util.Arrays;

public class FindAllPossibleStableBinaryArrays1_3129 {
    public static void main(String[] args) {
        System.out.println(numberOfStableArrays(14, 13, 59));
    }


    public static int numberOfStableArrays(int zero, int one, int limit) {
        int ans = 0;
        int mod = (int) (Math.pow(10, 9) + 7);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < one; i++) {
            stringBuilder.append("1");
        }
        for (int i = 0; i < zero; i++) {
            stringBuilder.append("0");
        }
        int maxValue = Integer.parseInt(stringBuilder.toString(), 2);
        for (int i = 0; i <= maxValue; i++) {
            StringBuilder string = new StringBuilder(Integer.toBinaryString(i));
            if (i != maxValue) {
                for (int j = string.length(); j < stringBuilder.length(); j++) {
                    string.insert(0, "0");
                }
            }
            if (isStabilize(string.toString(), zero, one, limit)) {
                System.out.println(string);
                ans = (ans + 1) % mod;
            }
        }
        return ans % mod;
    }

    public static boolean isStabilize(String string, int zero, int one, int limit) {
        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
        if (zeroCount != zero || oneCount != one) {
            return false;
        }

        int length = string.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String substring = string.substring(i, j);
                if (substring.length() > limit) {
                    if (!substring.contains("0") || !substring.contains("1")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
