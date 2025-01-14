package interview_150;

public class lengthOfLongestSubstring_3 {
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0;
        int right = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (right < s.length()) {
            while (stringBuilder.indexOf(String.valueOf(s.charAt(right))) != -1) {
                stringBuilder.deleteCharAt(0);
                left++;
            }
            stringBuilder.append(s.charAt(right++));
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
