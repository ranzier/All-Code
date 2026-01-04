package suixianglu.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class L452 {
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        int count = 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int sharedStart = points[0][0], sharedEnd = points[0][1];

        // 找到共同的交集
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > sharedEnd) { // 如果该气球不在交集内，重新设置交集并count++
                count++;
                sharedStart = points[i][0];
                sharedEnd = points[i][1];
                continue;
            }

            sharedStart = points[i][0];
            sharedEnd = Math.min(sharedEnd, points[i][1]);
        }
        return count + 1;
    }
}
