package Math;
/**
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 */
import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.List;

public class 最小时间差_539 {
    public static void main(String[] args) {

    }
    public int findMinDifference(List<String> timePoints) {
        int[] arr = new int[timePoints.size() * 2];
        int index = 0;
        for (int i = 0; i < timePoints.size(); i++, index += 2) {
            String currentTime = timePoints.get(i);
            int hour = Integer.parseInt(currentTime.split(":")[0]);
            int min = Integer.parseInt(currentTime.split(":")[1]);
            // 我们不仅记录「当天该时间点」对应的的偏移量，还记录「下一天该时间点」对应的偏移量。
            arr[index] = hour * 60 + min;
            arr[index + 1] = arr[index] + 1440;
        }
        Arrays.sort(arr);
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int value = arr[i + 1] - arr[i];
            minValue = Math.min(minValue, value);
        }
        return minValue;
    }
}
