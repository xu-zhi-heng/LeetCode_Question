package interview_150;

public class majorityElement_169 {
    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;
        int x = 0;
        for (int num : nums) {
            if (count == 0) {
                x = num;
            }
            if (x == num) {
                count++;
            } else {
                count--;
            }
        }
        return x;
    }
}
