package interview_150;

public class canCompleteCircuit_134 {

    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // 1. 如果当前的车站的加油量小于开往下一个站的耗油量，这个起始点不行
        // 2. 根据第一点，如果从起点开始，每一站的剩余油量之和小于下一站耗油量也不行
        // 用一个totalSum记录所有剩余油量之和，如果 totalSum < 0 说明不能从绕一圈
        // remainderSum 记录当前的剩余油量之和，如果 remainderSum < 0，代表从这个起点开始不行，因为在中途的时候就不能开往下一站了
        int i = 0;
        int remainderSum = 0;
        int totalSum = 0;
        int start = 0;
        while (i < gas.length) {
            totalSum += gas[i] - cost[i];
            remainderSum += gas[i] - cost[i];
            if (remainderSum < 0) {
                start = i + 1;
                remainderSum = 0;
            }
            i++;
        }
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }
}
