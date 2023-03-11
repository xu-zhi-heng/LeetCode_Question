package Hash;
import java.util.HashMap;
import java.util.List;
public class 旅行终点站_1436 {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < paths.size(); i++) {
            String cityA = paths.get(i).get(0);
            String cityB = paths.get(i).get(1);
            // 统计出有多少个城市
            hashMap.put(cityA, 0);
            hashMap.put(cityB, 0);
        }
        // 因为如果有一个城市是终点站的话，那么hashmap对应的key会是 0
        for (int i = 0; i < paths.size(); i++) {
            hashMap.put(paths.get(i).get(0), hashMap.get(paths.get(i).get(0)) + 1);
        }
        for (int i = 0; i < paths.size(); i++) {
            if (hashMap.get(paths.get(i).get(1)) == 0) {
                return paths.get(i).get(0);
            }
        }
        return "";
    }
}
