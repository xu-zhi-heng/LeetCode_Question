package SlidingWindow;

public class LongestTurbulentSubarray_978 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,8,45,88,48,68,28,55,17,24};
        System.out.println(maxTurbulenceSize(arr));
    }

    public static int maxTurbulenceSize(int[] arr) {
        int ans = 1;
        int length = arr.length;
        int left = 0;
        int right = 1;
        while (right < length) {
            while (right < length && arr[left] == arr[right]) {
                left++;
                right++;
            }
            if (right >= length) {
                break;
            }
            int preFlag = arr[left] > arr[right] ? 1 : 0;
            right++;
            for (int i = left + 1; i < length; i++) {
                if (right >= length) {
                    ans = Math.max(ans, right - left - 1);
                    break;
                }
                int curFlag = arr[i] > arr[right] ? 1 : 0;
                if (preFlag == curFlag || arr[i] == arr[right]) {
                    ans = Math.max(ans, right - left);
                    left = i;
                    break;
                } else {
                    preFlag = curFlag;
                    right++;
                }
            }
        }
        return ans;
    }
}
