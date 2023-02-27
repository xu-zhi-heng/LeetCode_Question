package Dynamic;

import java.util.*;

public class 得分最高的单词集合_1255 {
    public static void main(String[] args) {
        System.out.println(maxScoreWords(new String[]{"baaa","aacc","ccbc","da","dbbc"},
                new char[]{'a','a','a','c','c','c','c','c','d','d','d'},
                new int[]{9,4,10,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }
    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int ans = 0;

        // 统计letters中每个字符出现的次数
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : letters) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        List<List<String>> lists = buildSubSet(words);

        boolean flag;
        for (int i = 1; i < lists.size(); i++) {
            flag = true;
            int value = 0;
            for (int j = 0; j < lists.get(i).size(); j++) {
                String current = lists.get(i).get(j);
                for (int k = 0; k < current.length(); k++) {
                    if (counts.containsKey(current.charAt(k)) && counts.get(current.charAt(k)) > 0) {
                        value = value + score[current.charAt(k) - 'a'];
                        counts.put(current.charAt(k), counts.get(current.charAt(k)) - 1);
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                ans = Math.max(value, ans);
            }
            // 每次都要重新计数
            counts.clear();
            for (char letter : letters) {
                counts.put(letter, counts.getOrDefault(letter, 0) + 1);
            }
        }
        return ans;
    }

    // 求出数组所有的排列组合
    public static List<List<String>> buildSubSet(String[] words){
        List<List<String>> result = new ArrayList<>();
        //先添加一个空集
        result.add(new ArrayList<>());
        for (int i = 0; i < words.length; i++){
            //获取当前子集个数
            int size = result.size();
            //依次取出当前子集并为每一子集添加元素nums[i]
            //最后再添加回result
            for (int j = 0; j < size; j++){
                List<String> clone = new ArrayList<>(result.get(j));
                clone.add(words[i]);
                result.add(clone);
            }
        }
        return result;
    }
}
