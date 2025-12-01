package suixianglu.array;

import java.util.Scanner;

public class Kama44 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] array = new int[n][m];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                array[i][j] = sc.nextInt();

        // 统计前 n 行的前缀和
        int[] preSumRows = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += array[i][j];
            }
            if (i == 0) {
                preSumRows[i] = sum;
            } else {
                preSumRows[i] = preSumRows[i - 1] + sum;
            }
        }

        // 对行进行遍历切割，找出最小差距
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, Math.abs(preSumRows[n - 1] - 2 * preSumRows[i]));
        }

        // 统计前 m 列的前缀和
        int[] preSumColumns = new int[m];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += array[j][i];
            }
            if (i == 0) {
                preSumColumns[i] = sum;
            } else {
                preSumColumns[i] = preSumColumns[i - 1] + sum;
            }
        }

        // 对列进行遍历切割，找出最小差距
        for (int i = 0; i < m - 1; i++) {
            min = Math.min(min, Math.abs(preSumColumns[m - 1] - 2 * preSumColumns[i]));
        }

        System.out.println(min);
    }
}
