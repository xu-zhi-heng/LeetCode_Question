package Greedy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 分发糖果_135 {
    public static void main(String[] args) {
        int[] arr = {1,2,7,4,3,3,1};
        System.out.println(candy_02(arr));
    }

    /**
     * 超时
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);
        // 记录arr数组从小到大的顺序
        List<Integer> orderList = new ArrayList<>();
        // 对arr数组进行排序操作
        int[] orderArr = Arrays.copyOf(ratings, len);
        Arrays.sort(orderArr);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (orderList.contains(j)) {
                    continue;
                }
                if (orderArr[i] == ratings[j]) {
                    orderList.add(j);
                    break;
                }
            }
        }
        for (int i = 0; i < orderList.size(); i++) {
            int ordinalValue = orderList.get(i);
            if (ordinalValue > 0 && ratings[ordinalValue] > ratings[ordinalValue - 1]) {
                candies[ordinalValue] = Math.max(candies[ordinalValue], candies[ordinalValue - 1] + 1);
            }
            if (ordinalValue < len - 1 && ratings[ordinalValue] > ratings[ordinalValue + 1]) {
                candies[ordinalValue] = Math.max(candies[ordinalValue], candies[ordinalValue + 1] + 1);
            }
        }
        int sum = Arrays.stream(candies).sum();
        return sum;
    }

    public static int candy_02(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int count = left[ratings.length - 1];
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
