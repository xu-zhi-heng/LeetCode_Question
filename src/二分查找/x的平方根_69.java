package 二分查找;

public class x的平方根_69 {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        if(x == 1) {
            return 1;
        }
        int left = 0;
        int right = x / 2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if(mid * mid < x) {
                left = mid;
            } else if(mid * mid > x) {
                right = mid - 1;
            }
        }
        return left;
    }
}
