package Greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 加油站_134 {
    public static void main(String[] args) {

    }


    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        // 表示当前的油量
        int current = 0;
        // 从第几个车站开始
        int start = 0;
        // 将数组变为两倍，因为是一个环
        int[] gasCopy = Arrays.copyOf(gas, len);
        int[] costCopy = Arrays.copyOf(cost, len);
        int[] newGas = IntStream.concat(Arrays.stream(gas), Arrays.stream(gasCopy)).toArray();
        int[] newCost = IntStream.concat(Arrays.stream(cost), Arrays.stream(costCopy)).toArray();

        for (int i = 0; i < len * 2; i++) {
            if (i == start + len) {
                return start;
            }
            current = current + newGas[i] - newCost[i];
            if (current < 0) {
                start = i + 1;
                current = 0;
            }
        }
        return -1;
    }
}
