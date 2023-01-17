package Math;

import java.util.Arrays;

public class 最小操作次数使数组元素相等_453 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(minMoves(arr));
        System.out.println(minMoves2(arr));
    }
    public static int minMoves(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int[] newArr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            newArr[i] = nums[nums.length - 1];
        }
        if(Arrays.equals(nums,newArr)) {
            return count;
        }
        while(true) {
            for(int i = 0; i < nums.length - 1; i++) {
                nums[i] += 1;
            }
            count++;
            Arrays.sort(nums);
            for(int i = 0; i < nums.length; i++) {
                newArr[i] = nums[nums.length - 1];
            }
            if(Arrays.equals(nums,newArr)) {
                return count;
            }
        }
    }
    public static int minMoves2(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            if(num < minNum) {
                minNum = num;
            }
        }
        int count = 0 ;
        for (int num : nums) {
            count += num - minNum;
        }
        return count;
    }

}
