package Greedy;
public class 盛最多水的容器_11 {
    public static void main(String[] args) {
        int[] height = new int[]{2,3,4,5,18,17,6};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        if(height.length == 0 || height.length == 1) {
            return 0;
        }
        int maxSize = 0;
        int left = 0;
        int right = height.length - 1;

        while (left <= right) {
            int interval = right - left;
            int size = Math.min(height[left], height[right]);
            maxSize = Math.max(maxSize, size * interval);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxSize;
    }
}
