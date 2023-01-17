package Sort;
import java.util.*;
/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class 多数元素_169 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        System.out.println(majorityElement_02(arr));
    }

    public static int majorityElement(int[] nums) {
        int temp = 0;
        boolean flag = false;

        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j] > nums[j + 1]) {
                    flag = true;
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if(!flag) {
                break;
            } else {
                flag = false;
            }
        }
        System.out.println(Arrays.toString(nums));

        temp = nums[0];
        HashMap<Integer, Integer> hashMap = new HashMap();
        int count = 0;
        for (int num : nums) {
            if (num == temp) {
                count++;
            } else {
                hashMap.put(temp, count);
                temp = num;
                count = 1;
            }
        }
        hashMap.put(temp, count);

        Iterator<Map.Entry<Integer, Integer>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> next = it.next();
            if(next.getValue() > nums.length / 2) {
                return next.getKey();
            }
        }
        return 0;
    }

    // 采用位运算
    public static int majorityElement_02(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            int ones = 0;
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    ones++;
                }
            }
            if (ones > nums.length / 2) {
                ans += (1 << i);
            }
        }
        return ans;
    }
}
