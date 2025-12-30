package suixianglu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class L77 {
    public static void main(String[] args) {
        combine(4, 2);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    static List<List<Integer>> res;
    static List<Integer> list;

    public static List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        backtracking(n, k, 1);
        return res;
    }

    public static void backtracking(int n, int k, int start) {
        // 终止条件
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 遍历 + 回溯
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtracking(n, k, i + 1);
            list.removeLast();
        }
    }
}
