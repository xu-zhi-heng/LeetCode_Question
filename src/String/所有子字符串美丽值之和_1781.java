package String;
/**
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 */
public class 所有子字符串美丽值之和_1781 {
    public static void main(String[] args) {
        System.out.println(beautySum("kcgdnprqxcmpcavjzjgvgekzsvoejxwrdsidzitpzcegxrrrnayndadtqwqswuinzyhdewzzvukqbzobylcporryqpurrzzmidrjcgtfoeyycrsbpbinbzweirmlamaajudtaermybbopxknkwalbnowfsevnodehzdalgailizfvnenmfuatxieorjaybxilmjsslalgeecmsbqwdjntfoaizbpmxekrtesrguepsevaymfwetnddblkbrirhrxrxvrpnqtazyurmwmlxtxczsypiycedwdgyzelbyapgfmedpzbfjfmbtydaqnshncgciqhatuzzpjklomxxqkdvrcwpotadandkwkfnrgiugpxyfjzzwkfdlvytfufxpsdwgmrqzufghuyq"));
    }

    public static int beautySum(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int sum = 0;
        // 通过i和j两个指针遍历出所有的子字符串，这里没有使用到subString方法： subString一次性将字符串都取出，
        // 这样导致在取大小值的时候，还需要进行遍历，浪费时间，通过双指针的做法是
        // "aabcd" => a => aa => aab..., 因为是顺序进行的，所有有一种类似于记忆在里面，
        // 涉及到字母时，可以通过数组进行计数
        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[26];
            int maxValue = 0;
            for (int j = i; j < s.length(); j++) {
                // j遍历一轮，前面存在过值，当字串变长时，就不要改动，count中
                count[s.charAt(j) - 'a']++;
                maxValue = Math.max(maxValue, count[s.charAt(j) - 'a']);
                int minValue = s.length();
                for (int k = 0; k < 26; k++) {
                    if (count[k] > 0) {
                        minValue = Math.min(minValue, count[k]);
                    }
                }
                sum += maxValue - minValue;
            }
        }
        return sum;
    }
}
