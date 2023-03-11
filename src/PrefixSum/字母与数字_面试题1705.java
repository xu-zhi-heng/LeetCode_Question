package PrefixSum;

import java.util.HashMap;

public class 字母与数字_面试题1705 {
    public String[] findLongestSubarray(String[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;
        int startIndex = -1;
        hashMap.put(0, -1);
        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i].charAt(0))) {
                prefixSum++;
            } else {
                prefixSum--;
            }
            if (hashMap.containsKey(prefixSum)) {
                int firstIndex = hashMap.get(prefixSum);
                if (i - firstIndex > maxLength) {
                    maxLength = i - firstIndex;
                    startIndex = firstIndex + 1;
                }
            } else {
                hashMap.put(prefixSum, i);
            }
        }
        if (maxLength == 0) {
            return new String[]{};
        }
        String[] result = new String[maxLength];
        // 从array数组的startIndex位置开始拷贝到result数组从0下标开始，长度为maxLength
        System.arraycopy(array, startIndex, result, 0, maxLength);
        return result;
    }
}
