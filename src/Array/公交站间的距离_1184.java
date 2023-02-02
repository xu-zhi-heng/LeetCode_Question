package Array;

/**
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 *
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 *
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 */
public class 公交站间的距离_1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) return 0;
        int ans = 0;
        int sum = 0;
        for (int value : distance) {
            sum += value;
        }
        for (int i = Math.min(start,destination); i < Math.max(start,destination); i++) {
            ans += distance[i];
        }
        // ans 代表顺时针的一种或者逆时针，sum - ans代表另一种
        return Math.min(ans, sum - ans);
    }
}
