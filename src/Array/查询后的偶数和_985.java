package Array;

/**
 * 给出一个整数数组 A 和一个查询数组 queries。
 *
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 *
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 *
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 */
public class 查询后的偶数和_985 {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int sum = 0;
        // 先求出最原始数组中偶数和是多少
        for (int num : nums) {
            if (Math.abs(num) % 2 == 0) {
                sum += num;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            // 每次只改变数组中一个数的值，所有我们只需要根据更新的值是否是偶数对初始偶数值进行改变即可
            // 如果一开始是偶数，先剪掉，再看加上数后是否还是偶数
            if (nums[index] % 2 == 0) sum -= nums[index];
            nums[index] += val;
            if (nums[index] % 2 == 0) sum += nums[index];
            ans[i] = sum;
        }
        return ans;
    }
}
