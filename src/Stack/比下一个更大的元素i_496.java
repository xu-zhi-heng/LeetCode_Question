package Stack;

public class 比下一个更大的元素i_496 {
    public static void main(String[] args) {

    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int index = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int k = j; k < nums2.length; k++) {
                        if (nums2[k] > nums2[j]) {
                            ans[index] = nums2[k];
                            break;
                        }
                    }
                    if (ans[index] == 0) {
                        ans[index] = -1;
                    }
                    index++;
                }
            }
        }

        return ans;
    }
}
