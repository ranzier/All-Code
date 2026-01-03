package suixianglu.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L406 {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = reconstructQueue(people);
        for (int[] ints : res) {
            for (int i : ints)
                System.out.print(i + ",");
            System.out.println();
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];   // 身高相同，k 升序
            }
            return b[0] - a[0];       // 身高不同，h 降序
        });

        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] array : people) {
            queue.add(array[1], array); // array[1]: 表示有array[1]个人身高比array更高，所以array要放在index为array[1]的位置
        }

        return queue.toArray(new int[people.length][]); // 集合转换成数组
    }
}
