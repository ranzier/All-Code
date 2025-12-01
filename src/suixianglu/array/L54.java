package suixianglu.array;

import java.util.ArrayList;
import java.util.List;

public class L54 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;

        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) { // 从左到右
                list.add(matrix[top][j]);
            }
            top++;

            for (int i = top; i <= bottom; i++) { // 从上到下
                list.add(matrix[i][right]);
            }
            right--;

            // 因为先前 top 改变了，所以要判断一下
            if (top <= bottom) {
                for (int j = right; j >= left; j--) { // 从右到左
                    list.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // 因为先前 right 改变了，所以要判断一下
            if (left <= right) {
                for (int i = bottom; i >= top; i--) { // 从下到上
                    list.add(matrix[i][left]);
                }
                left++;
            }

        }
        return list;
    }
}
