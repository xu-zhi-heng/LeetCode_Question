package Array;

import java.util.*;

/**
 * 超时
 */
public class 三数之和_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,-1,0,-1};
//        System.out.println(threeSum(nums));
        System.out.println(new Date());
        Arrays.sort(nums);
        System.out.println(traverse(nums));
        System.out.println(new Date());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length == 0) {
            return list;
        }
        int[] used = new int[nums.length];
        perm(list, nums, 3, 0, 0, new Stack<>(), used);
        return list;
    }

    public static void perm(List<List<Integer>> list, int[] nums, int target, int has, int cur, Stack<Integer> stack, int[] used) {
        if(has == target) {
            int result = 0;
            for(int num : stack) {
                result += num;
            }
            if(result == 0) {
                List<Integer> list1 = new ArrayList<>(stack);
                Collections.sort(list1);    // 对list中的元素进行排序，方便判断大的list中是否包含小的list
                if(!list.contains(list1)) {
                    list.add(list1);
                }
            }
        }
        for(int i = cur; i < nums.length; i++) {
            if(used[i] == 0) {
                stack.add(nums[i]);
                used[i] = 1;
                perm(list, nums, target, has + 1, i, stack, used);
                used[i] = 0;
                stack.pop();
            }
        }
    }

    public static List<List<Integer>> traverse(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            for(int j = i + 1; j < nums.length; j++) {
                List<Integer> search = search(nums, nums[i], nums[j], j + 1);
                for(int value : search) {
                    List<Integer> list = new ArrayList<>();
                    list.add(value);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    Collections.sort(list);
                    if(!lists.contains(list)) {
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }

    public static List<Integer> search(int[] nums, int number1, int number2, int start) {
        List<Integer> list = new ArrayList<>();
        for(int k = start; k < nums.length; k++) {
            if(number1 + number2 + nums[k] == 0) {
                list.add(nums[k]);
            }
        }
        return list;
    }

    public static int binarySearch(int[] nums, int number1, int number2, int start) {
        int low = start;
        int high = nums.length-1;
        while(low <= high) {
            int middle = (low + high)/2;
            if(nums[middle] + number1 + number2 == 0) {
                return middle;
            }else if(number1 + number2 < nums[middle]) {
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
