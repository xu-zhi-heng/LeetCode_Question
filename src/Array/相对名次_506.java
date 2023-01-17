package Array;

import java.util.Arrays;

public class 相对名次_506 {
    public static void main(String[] args) {
        int[] nums = {10,3,8,9,4};
        int[] copynums = nums;
        Arrays.sort(copynums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(copynums));
        System.out.println(Arrays.toString(findRelativeRanks(nums)));
    }
    public static String[] findRelativeRanks(int[] nums) {
        String[] str = new String[nums.length];
        String[] gard = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[] copynums = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            copynums[i] = nums[i];
        }
        Arrays.sort(copynums);
        int count = 0;
        for(int i = copynums.length - 1; i >= 0; i--) {
            for(int j = 0; j < nums.length; j++) {
                if(i > copynums.length - 4) {
                    if(copynums[i] == nums[j]) {
                        str[j] = gard[count++];
                        continue;
                    }
                }else {
                    if(copynums[i] == nums[j]) {
                        str[j] = count + 1 + "";
                        count++;
                        continue;
                    }
                }
            }
        }
        return str;
    }
}
