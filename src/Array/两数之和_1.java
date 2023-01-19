package Array;

import java.util.HashMap;
import java.util.Map;

public class 两数之和_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashTable = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(hashTable.containsKey(target - nums[i])) {
                return new int[]{hashTable.get(target - nums[i]), i};
            }
            hashTable.put(nums[i],i);
        }
        return new int[0];
    }
}
