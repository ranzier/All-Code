package suixianglu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class L39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        combinationSum(candidates, target);
        for (List<Integer> list1 : res)
            System.out.println(list1);
    }

    static List<List<Integer>> res;
    static List<Integer> list;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        list = new ArrayList<>();
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
            list.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i, sum);
            sum -= list.getLast();
            list.removeLast();
        }
    }
}
