package suixianglu.tree;

import java.util.HashMap;
import java.util.Map;

public class L105 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root.val);
    }

    static Map<Integer, Integer> map;
    static int prev;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        prev = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int[] inorder, int left, int right) {
        if (left > right)
            return null;

        TreeNode root = new TreeNode(preorder[prev]);
        int index = map.get(preorder[prev]);
        prev++;

        root.left = build(preorder, inorder, left, index - 1);
        root.right = build(preorder, inorder, index + 1, right);

        return root;
    }
}
