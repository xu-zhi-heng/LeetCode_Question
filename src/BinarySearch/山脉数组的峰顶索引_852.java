package BinarySearch;

public class 山脉数组的峰顶索引_852 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,10,5,2};
        System.out.println(peakIndexInMountainArray(arr));
    }
    public static int peakIndexInMountainArray(int[] arr) {
        // 找最大值即可
//        int max = arr[0];
//        int index = 0;
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > max) {
//                max = arr[i];
//                index = i;
//            }
//        }
//        return index;
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
