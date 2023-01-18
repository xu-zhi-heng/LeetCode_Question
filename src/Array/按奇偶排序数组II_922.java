package Array;

public class 按奇偶排序数组II_922 {
    public int[] sortArrayByParityII(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if ((i % 2 == 0 && nums[i] % 2 == 0) || (i % 2 != 0 && nums[i] % 2 != 0)) {

            } else {
                if (i % 2 == 0) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] % 2 == 0) {
                            int temp = nums[j];
                            nums[j] = nums[i];
                            nums[i] = temp;
                        }
                    }
                } else {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] % 2 != 0) {
                            int temp = nums[j];
                            nums[j] = nums[i];
                            nums[i] = temp;
                        }
                    }
                }
            }
        }
        return nums;
    }

    // 更好的做法：
    /**
     * 两次遍历
     * 遍历一遍数组把所有的偶数放进 ans[0]\textit{ans}[0]ans[0]，ans[2]\textit{ans}[2]ans[2]，ans[4]\textit{ans}[4]ans[4]，以此类推。
     * 再遍历一遍数组把所有的奇数依次放进 ans[1]\textit{ans}[1]ans[1]，ans[3]\textit{ans}[3]ans[3]，ans[5]\textit{ans}[5]ans[5]，以此类推。
     */
}
