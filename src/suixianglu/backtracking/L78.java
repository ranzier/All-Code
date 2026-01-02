package suixianglu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class L78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsets(nums);
        for (List<Integer> list1 : res)
            System.out.println(list1);

    }

    static List<List<Integer>> res;
    static List<Integer> list;

    public static List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        backtracking(nums, 0);
        res.add(new ArrayList<>());
        return res;
    }

    public static void backtracking(int[] nums, int start) {
        if (!list.isEmpty()) {
            res.add(new ArrayList<>(list)); // if里面去掉return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(nums, i + 1);
            list.removeLast();
        }
    }
}
