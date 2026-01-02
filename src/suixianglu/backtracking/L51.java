package suixianglu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L51 {
    public static void main(String[] args) {
        solveNQueens(4);
        for (List<String> list : res)
            System.out.println(list);
    }

    static List<List<String>> res;

    public static List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] chess = new char[n][n];
        for (char[] chars1 : chess)
            Arrays.fill(chars1, '.');
        backtracking(chess, 0, n);
        return res;
    }

    public static void backtracking(char[][] chess, int row, int n) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : chess) {
                list.add(new String(chars));
            }
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(chess, row, i, n)) {
                chess[row][i] = 'Q';
                backtracking(chess, row + 1, n);
                chess[row][i] = '.';
            }
        }
    }

    public static boolean isValid(char[][] chess, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (chess[i][col] == 'Q')
                return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (chess[i][j] == 'Q')
                return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (chess[i][j] == 'Q')
                return false;

        return true;
    }
}
