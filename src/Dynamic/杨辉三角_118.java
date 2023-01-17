package Dynamic;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角_118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows < 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> first = new ArrayList<>();
        first.add(1);

        result.add(first);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i - 1; j++) {
                List<Integer> temp = result.get(i - 2);
                list.add(temp.get(j - 1) + temp.get(j));
            }
            list.add(1);

            result.add(list);
        }
        return result;
    }
}
