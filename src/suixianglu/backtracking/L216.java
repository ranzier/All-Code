package suixianglu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class L216 {
    public static void main(String[] args) {
        combinationSum3(3, 7);
        for (List<Integer> list1 : res)
            System.out.println(res);
    }

    static List<List<Integer>> res;
    static List<Integer> list;

    public static List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        backtracking(k, n, 1);
        return res;
    }

    public static void backtracking(int k, int n, int start) {
        // 终止条件
        if (k == list.size()) {
            int sum = 0;
            for (int num : list)
                sum += num;
            if (sum == n) {
                res.add(new ArrayList<>(list));
                return;
            }
        }

        // 遍历
        for (int i = start; i <= 9; i++) {
            list.add(i);
            backtracking(k, n, i + 1); // 递归
            list.removeLast(); //回溯
        }
    }
}
