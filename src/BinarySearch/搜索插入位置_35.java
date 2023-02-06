package BinarySearch;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class 搜索插入位置_35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        int midValue = nums[mid];

        while (left <= right) {
            if(midValue < target) {
                left = mid + 1;
            } else if(midValue > target) {
                right = mid - 1;
            } else {
                return mid;
            }
            mid = (left + right) / 2;
            midValue = nums[mid];
        }
        return right + 1;
    }
}
