import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();   // 有多少次计算，用来控制最外层循环，可以不要
//        int i;
//        while (t > 0) {
//            // 两个整数a，b
//            int m = sc.nextInt();
//            int n = sc.nextInt();
//            // 保留多少位小数
//            int k = sc.nextInt();
//            t--;
//            // 定义一个数组用来保存结果。k+2的原因是因为有一个商存在，还有考虑到是否四舍五入的原因
//            int[] a = new int[k + 2];
//            //  商的整数部分 a[0].xxxxxxxxxxxxxx
//            a[0] = m / n;
//            //  模拟手算除法计算余数: 意思就是，平时做除法运算时候， 得到一个余数结果后，不够接着除以除数，就会往后面添加一个0，添加一个0的过程就是*10
//            m = m % n * 10;
//
//            // 有多少位小数就需要多少次循环
//            for(i = 1; i < k + 2; i++)
//            {
//                a[i] = m / n;
//                m = m % n * 10;
//            }
//
//            // 第k+1位四舍五入，这一步有问题，应该是如果第k+1位 > 5的话第k位就 + 1
////            a[k] = a[k] + a[k+1];
//            if(a[k + 1] >= 5) {
//                a[k]++;
//            }
//
//            // 处理进位，我也不明白为什么要进位，除法运算能够上每次上的数大于10嘛
//            // 余数必须小于除数
////            for(i = k; i > 0 && a[i] > 9; i--){
////                a[i-1]++;
////                a[i] -= 10;
////            }
//
//            // 输出
//            System.out.print(a[0] + ".");
//            for(i = 1; i <= k; i++){
//                System.out.print(a[i]);
//            }
//        }
        print(2);
    }

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }
}
