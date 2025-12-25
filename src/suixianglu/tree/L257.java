package suixianglu.tree;

import java.util.ArrayList;
import java.util.List;

public class L257 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> res = binaryTreePaths(root);
        System.out.println(res);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return result;
        treePaths(root, list, result);
        return result;
    }

    public static void treePaths(TreeNode root, List<Integer> list, List<String> res) {
        list.add(root.val);

        // 如果当前是叶子节点
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i)).append("->");
            }
            sb.append(list.getLast());
            res.add(new String(sb));
        }

        // 左子树递归
        if (root.left != null) {
            treePaths(root.left, list, res);
        }

        // 右子树递归
        if (root.right != null) {
            treePaths(root.right, list, res);
        }

        // 回溯删除最后一个元素
        list.removeLast();
    }
}
