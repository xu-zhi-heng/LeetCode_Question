package interview_150;

public class twoSum_167 {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        int ans = 0;
        while (left < right) {
            ans = numbers[left] + numbers[right];
            if (ans == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            if (ans > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
