package suixianglu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L90 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        subsetsWithDup(nums);
        for (List<Integer> list1 : res)
            System.out.println(list1);

    }

    static List<List<Integer>> res;
    static List<Integer> list;

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        Arrays.sort(nums); // 先排序
        backtracking(nums, 0);
        res.add(new ArrayList<>());
        return res;
    }

    public static void backtracking(int[] nums, int start) {
        if (!list.isEmpty()) {
            res.add(new ArrayList<>(list));
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) // 在每一层中去重
                continue;
            list.add(nums[i]);
            backtracking(nums, i + 1);
            list.removeLast();
        }
    }
}
