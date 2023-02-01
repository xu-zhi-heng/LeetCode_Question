package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i （以字符串形式）如果上述条件全不满足。
 */
public class FizzBuzz_412 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if((i + 1) % 3 == 0) {
                if((i + 1) % 5 == 0) {
                    list.add("FizzBuzz");
                }else {
                    list.add("Fizz");
                }
            }else if((i + 1) % 5 == 0) {
                list.add("Buzz");
            }else{
                list.add((i + 1) + "");
            }
        }
        return list;
    }
}
