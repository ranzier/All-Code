package suixianglu.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L501 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        int[] res = findMode(root);
        System.out.println(res[0]);
    }

    static int maxNum;
    static List<Integer> list;
    static Integer prev;
    static int sum;

    public static int[] findMode(TreeNode root) {
        maxNum = Integer.MIN_VALUE;
        list = new ArrayList<>();
        prev = null;
        sum = 0;
        inorder(root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        if (prev != null && prev.equals(root.val)) {
            sum++;
        } else {
            sum = 1;
        }

        if (sum > maxNum) {
            list = new ArrayList<>();
            list.add(root.val);
            maxNum = sum;
        } else if (sum == maxNum) {
            list.add(root.val);
            maxNum = sum;
        }
        prev = root.val;

        inorder(root.right);
    }
}
