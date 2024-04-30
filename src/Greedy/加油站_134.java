package Greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 加油站_134 {
    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        int start = 0;
        int currentGasTotal = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];
            currentGasTotal += rest;
            total += rest;
            if (currentGasTotal < 0) {
                start = i + 1;
                currentGasTotal = 0;
            }
        }
        if (total < 0) {
            System.out.println(-1);
        } else {
            System.out.println(start);
        }
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
