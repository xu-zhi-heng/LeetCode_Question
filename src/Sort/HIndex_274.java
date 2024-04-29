package Sort;

import java.util.Arrays;

public class HIndex_274 {
    public static void main(String[] args) {

    }

    public static int hIndex(int[] citations) {
        int h = 0;
        Arrays.sort(citations);
        int len = citations.length - 1;
        int count = 0;
        for (int i = 0; i <= len; i++) {

        }
        return h;
    }
}
