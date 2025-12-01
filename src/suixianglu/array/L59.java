package suixianglu.array;

public class L59 {

    public static void main(String[] args) {
        int n = 4;
        int[][] array = generateMatrix(n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                System.out.print(array[i][j] + ",");
    }


    // 模拟：用上下左右边界对数组的赋值进行限制
    public static int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];
        int num = 1;
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;

        while (left <= right && top <= bottom) {

            // → 向右
            for (int y = left; y <= right; y++) {
                array[top][y] = num++;
            }
            top++;

            // ↓ 向下
            for (int x = top; x <= bottom; x++) {
                array[x][right] = num++;
            }
            right--;

            // ← 向左
            if (top <= bottom) {
                for (int y = right; y >= left; y--) {
                    array[bottom][y] = num++;
                }
                bottom--;
            }

            // ↑ 向上
            if (left <= right) {
                for (int x = bottom; x >= top; x--) {
                    array[x][left] = num++;
                }
                left++;
            }
        }

        return array;
    }

}