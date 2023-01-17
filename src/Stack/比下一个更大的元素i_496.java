package Stack;

public class 比下一个更大的元素i_496 {
    public static void main(String[] args) {

    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length; // nums1的长度
        int len2 = nums2.length; // nums2的长度
        if(len1 == 0 || len2 ==0) return new int[0]; // 如果都没元素就返回一个空的数组
        int[] next1 = new int[len1]; // 返回的数组
        int[] next2 = new int[len2]; // 记录nums2的数组
        next2[len2-1] = -1; // nums2的最后一个元素后没有元素了，所以为-1
        for(int i = len2-2;i>=0; i--){
            if(nums2[i] < nums2[i+1]) next2[i] = i+1; // 如果i+1位置的元素比i位置的元素要大，就记录
            else{
                int next = next2[i+1];
                while(next!=-1 && nums2[i] > nums2[next])
                    next= next2[next];
                next2[i] = next;
            }
        }
        for(int i = 0; i<len1;i++){
            int cur = nums1[i];
            int j = 0;
            while(nums2[j] != cur) j++;
            next1[i] = next2[j] == -1?-1:nums2[next2[j]];
        }
        return next1;
    }
}
