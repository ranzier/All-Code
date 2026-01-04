package suixianglu.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge(intervals);
        for (int[] ints : res) {
            for (int i : ints)
                System.out.print(i + ",");
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // 先排序
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
                continue;
            }
            end = Math.max(end, intervals[i][1]);
        }
        list.add(new int[]{start, end}); //最后一个区间别忘加了
        return list.toArray(new int[list.size()][2]);
    }
}
