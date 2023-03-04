package String;

import java.util.HashMap;

public class 保证文件名唯一_1487 {
    public String[] getFolderNames(String[] names) {
        String[] result = new String[names.length];
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            // 如果没有该文件名，则直接创建，并且记录这个文件出现的次数为 1 次
            if (!hashMap.containsKey(name)) {
                result[i] = name;
                hashMap.put(name, 1);
            } else {
                // 出现过的话，先获得这个名字出现了几次
                int index = hashMap.get(name);
                // 依次增加，判断这个是否出现过，直到没有出现为止
                while (hashMap.containsKey(name + "(" + index + ")")) {
                    index++;
                }
                result[i] = name + "(" + index + ")";
                // 新的出现一次
                hashMap.put(name + "(" + index + ")", 1);
                // 旧的加一次
                hashMap.put(name, index + 1);
            }
        }
        return result;
    }
}
