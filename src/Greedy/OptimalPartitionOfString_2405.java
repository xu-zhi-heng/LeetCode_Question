package Greedy;

import java.util.Arrays;

public class OptimalPartitionOfString_2405 {
    public static void main(String[] args) {
        System.out.println(partitionString("ssssss"));
    }

    public static int partitionString(String s) {
        int res = 0;
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            if (hash[index] != 0) {
                res++;
                Arrays.fill(hash, 0);
            }
            hash[index]++;
        }
        if (Arrays.stream(hash).anyMatch(num -> num != 0)) {
            res++;
        }
        return res;
    }
}
