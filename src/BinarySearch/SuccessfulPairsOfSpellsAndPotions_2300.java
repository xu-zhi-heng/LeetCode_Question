package BinarySearch;

import java.math.BigDecimal;
import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions_2300 {
    public static void main(String[] args) {
        int[] spells = new int[]{5,1,3};
        int[] potions = new int[]{1,2,3,4,5};
        long success = 7;
        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = potions.length - 1;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                int value = (int) (success % potions[middle] == 0 ? success / potions[middle] : success / potions[middle] + 1);
                if (value <= spells[i]) {
                    res[i] += right - middle + 1;
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return res;
    }
}
