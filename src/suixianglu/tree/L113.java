package suixianglu.tree;

import java.util.ArrayList;
import java.util.List;

public class L113 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        System.out.println(pathSum(root, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        findPath(root, targetSum, res, new ArrayList<>());
        return res;
    }

    public static void findPath(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> list) {
        if (root == null)
            return;

        list.add(root.val);
        int sum = 0;
        for (int num : list)
            sum += num;
        if (root.left == null && root.right == null && sum == targetSum) {
            res.add(new ArrayList<>(list));
        }

        findPath(root.left, targetSum, res, list);
        findPath(root.right, targetSum, res, list);
        list.removeLast(); // 记得回溯
    }
}
