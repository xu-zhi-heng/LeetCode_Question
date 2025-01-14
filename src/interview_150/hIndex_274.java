package interview_150;

public class hIndex_274 {

    public static void main(String[] args) {
        int[] citations = new int[]{3,0,6,1,5};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        // 题目意思： 求一个h，使得数组中至少有h个数大于h
        // 根据题意 h不可能大于数组的长度（因为个数要大于h，而 h <= 数组的长度 ）

        // 计数：统计引用次数的个数，最后计数数组表达的意思就是： 下标表示引用论文的次数，值代表这个引用论文次数在数组中出现的个数
        int[] countArr = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            // Math.min(citations[i], citations.length)： 根据h不可能大于数组的长度，所以即使是6，也只能看作引用次数是5的
            countArr[Math.min(citations[i], citations.length)]++;
        }

        // i = 5 countArr[5] = 2 => 表达的意思就是说 没有5(i)篇论文的次数大于等于 5
        int count = 0;
        for (int i = countArr.length - 1; ; i--) {
            count += countArr[i];
            if (count >= i) {
                return i;
            }
        }
    }
}
