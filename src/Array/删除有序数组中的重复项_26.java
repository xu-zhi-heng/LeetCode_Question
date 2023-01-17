package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 *
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class 删除有序数组中的重复项_26 {
    public static void main(String[] args) {
        int[] nums = new int[]{-3,-1,-1,0,0,0,0,0,2};
//        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates_03(nums));
    }

    public static int removeDuplicates_01(int[] nums) {
        // 因为数组一开始就是有序的，那么相同的元素肯定相邻在一起，那么可以将重复的元素进行标记，这边就直接赋值，这样剩下的就是不重复的
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    nums[j] = Integer.MAX_VALUE;
                } else {
                    break;
                }
            }
        }
        // 对数组进行排序，最大值都排到了最后，只要值不等于最大值，就是不重复的元素
        Arrays.sort(nums);
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != Integer.MAX_VALUE) {
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

    public static int removeDuplicates_02(int[] nums) {
        int k = 0;
        int index = 0;

        for(int i = 1 ; i < nums.length ; i++){
            if( nums[index] != nums[i]){
                nums[++index] = nums[i];
            }
        }
        index++ ;

        for(int i = 0 ; i<index ; i++ )
            System.out.println(nums[i]);
        System.out.println("array集合元素个数："+ index);
        return k;
    }


    public static int removeDuplicates_03(int[] nums) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[i] == nums[j] && i != j) {
//                    int index = Math.min(i, j);
//                    while (index < nums.length - 1) {
//                        nums[index] = nums[index + 1];
//                        index++;
//                    }
//                }
//            }
//        }
        int length = nums.length;
        // 删除重复元素
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++)
                if (nums[i] == nums[j])
                {
                    for (int k = j; k < length - 1; k++) {
                        //从num[j]开始，所有数字前移一位
                        nums[k] = nums[k + 1];
                    }
                    //数组长度-1
                    length--;
                    //因为有++j，所以这里先减一下，否则num[i]比较的是移动之后的下一位，会漏掉一个数
                    j--;
                }
        }
        // 统计数组中不重复的元素
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(!list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }
        System.out.println(Arrays.toString(nums));
        return list.size();
    }

    // 双指针思想
    public static int removeDuplicates_04(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 因为数组中至少要保留一位元素，所有从1开始即可
        int fast = 1;
        int slow = 1;

        while (fast < nums.length) {
            if(nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        System.out.println(Arrays.toString(nums));

        return slow;
    }
}
