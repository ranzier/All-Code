package suixianglu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L40 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        combinationSum2(candidates, target);
        for (List<Integer> list1 : res)
            System.out.println(list1);
    }

    static List<List<Integer>> res;
    static List<Integer> list;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        Arrays.sort(candidates); // 先排序
        backtracking(candidates, target, 0, 0);

        return res;
    }

    public static void backtracking(int[] candidates, int target, int start, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target)
            return;

        for (int i = start; i < candidates.length; i++) {
            // 要对同一层的元素先进行去重
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            list.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i + 1, sum);
            sum -= list.getLast();
            list.removeLast();
        }
    }
}
