package Array;

import java.util.*;

public class 第三大的数_414 {
    public static void main(String[] args) {
        int[] arr = {-1,-2,-8,5,6,8,-7,-20,5,7,6};
        System.out.println(thirdMax(arr));
    }
    public static int thirdMax(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }else if(nums.length == 2) {
            Arrays.sort(nums);
            return nums[1];
        }else{
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
            LinkedHashSet<Object> temp =new LinkedHashSet<>();
            for(int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            List<Object> list = new ArrayList<Object>(temp);
//            System.out.println(Arrays.toString(list.toArray()));
            if(list.size() == 1) {
                return (int) list.get(0);
            }else if(list.size() == 2) {
                return (int) list.get(1);
            }else {
                return (int) list.get(list.size() - 3);
            }
        }
    }
}
