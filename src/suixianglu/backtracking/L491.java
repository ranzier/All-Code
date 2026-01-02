package suixianglu.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L491 {
    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        findSubsequences(nums);
        for (List<Integer> list1 : res)
            System.out.println(list1);
    }

    static List<List<Integer>> res;
    static List<Integer> list;

    public static List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        backtracking(nums, 0);
        return res;
    }

    public static void backtracking(int[] nums, int start) {
        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
        }

        Set<Integer> set = new HashSet<>(); // 使用set集合进行去重
        for (int i = start; i < nums.length; i++) {
            if (!list.isEmpty() && nums[i] < list.getLast() || set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            list.add(nums[i]);

            backtracking(nums, i + 1);
            if (!list.isEmpty())
                list.removeLast();
        }
    }
}
