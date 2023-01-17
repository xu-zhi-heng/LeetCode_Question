package String;

import java.util.ArrayList;
import java.util.List;

public class 宝石与石头_771 {
    public int numJewelsInStones(String jewels, String stones) {
        if (jewels.length() == 0 || stones.length() == 0) return 0;
        int count = 0;
        List<Character> jewelsList = new ArrayList<>();
        for (int i = 0; i < jewels.length(); i++) {
            jewelsList.add(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            if (jewelsList.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
