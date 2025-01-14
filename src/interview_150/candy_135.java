package interview_150;

import java.util.Arrays;

public class candy_135 {
    public static void main(String[] args) {
        int[] ratings = new int[]{1,2,87,87,87,2,1};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        // 两次遍历，每次只确定一边
        int[] nums = new int[ratings.length];
        Arrays.fill(nums, 1);
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                nums[i + 1] = nums[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && nums[i - 1] <= nums[i]) {
                nums[i - 1] = nums[i] + 1;
            }
         }
        return Arrays.stream(nums).sum();
    }
}
