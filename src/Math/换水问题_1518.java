package Math;

import java.util.ArrayList;
import java.util.List;

public class 换水问题_1518 {
    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
    }
    public static int numWaterBottles(int numBottles, int numExchange) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numBottles; i++) {
            list.add(1);
        }
        for(int i = 0; i <= list.size(); i++) {
            if(i % numExchange == 0 && i != 0) {
                list.add(1);
            }
        }
        return list.size();
    }
}
