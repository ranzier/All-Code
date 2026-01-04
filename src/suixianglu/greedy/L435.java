package suixianglu.greedy;

import java.util.Arrays;

public class L435 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        int start = intervals[0][0], end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) { // 如果当前区间与上一个区间没有重叠，则跳过
                start = intervals[i][0];
                end = intervals[i][1];
                continue;
            }

            if (end <= intervals[i][1]) { // 如果有重叠，且当前区间伸的更远，则保留上一个区间，删除当前区间
                count++;
            } else { // 如果有重叠，且上一个区间伸的更远，则保留当前区间，删除上一个区间
                count++;
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return count;
    }
}
