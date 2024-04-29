package Dynamic;

public class 跳跃游戏2_45 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,2,3};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int maxDistance = 0;
        int curDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]); // 此时从i位置能够覆盖的最大范围的终点位置
            if (maxDistance >= nums.length - 1) {             // 如果当前能够覆盖最大的位置终点能够到达末尾，那么只需要走一步即可
                count++;
                return count;
            }
            // 如果已经到达了覆盖的终点就需要进行更新
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}
