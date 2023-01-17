package Array;

import java.util.*;

public class 找到所有数组中消失的数字_448 {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(arr);
        System.out.println(disappearedNumbers);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len + 1];
        for(int num : nums) {
            temp[num] = num;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < temp.length; i++) {
            if(temp[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
