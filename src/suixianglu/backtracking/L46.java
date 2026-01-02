package suixianglu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class L46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
        for (List<Integer> list1 : res)
            System.out.println(list1);
    }

    static List<List<Integer>> res;
    static List<Integer> list;
    static boolean[] used;

    public static List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        used = new boolean[nums.length];
        backtracking(nums);
        return res;
    }

    public static void backtracking(int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) { // 每一层都从0到nums.length-1遍历
            if (used[i]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            list.removeLast();
            used[i] = false;
        }
    }
}
