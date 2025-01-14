package BitOperation;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReverseBits_190 {

    public static void main(String[] args) {
        int x = 0b11111111111111111111111111111101;
        System.out.println(reverseBits(x));
    }

    public static int reverseBits(int n) {
        long aLong = Integer.toUnsignedLong(n);
        long ans = 0;
        StringBuilder binaryStr = new StringBuilder();
        int length = 32;
        while (length > 0) {
            long bit = aLong % 2;
            binaryStr.append(bit);
            aLong  = aLong / 2;
            length--;
        }
        System.out.println(binaryStr);
        int base = 31;
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                ans += Math.pow(2, base);
            }
            base--;
        }
        return (int) ans;
    }


    public int countWays(List<Integer> nums) {
        int ans = 0;
        Collections.sort(nums);
        int max = nums.get(nums.size() - 1);

        


        return ans;
    }
}
