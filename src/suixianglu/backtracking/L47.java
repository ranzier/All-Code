package suixianglu.backtracking;

import java.util.*;

public class L47 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        permuteUnique(nums);
        for (List<Integer> list1 : res)
            System.out.println(list1);
    }

    static List<List<Integer>> res;
    static List<Integer> list;
    static boolean[] used;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums); // 排序
        backtracking(nums);
        return res;
    }

    public static void backtracking(int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) { // 去重
                continue;
            }
            if (used[i])
                continue;
            list.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            list.removeLast();
            used[i] = false;
        }
    }
}
