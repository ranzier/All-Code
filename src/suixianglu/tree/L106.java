package suixianglu.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L106 {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7}, postorder = {9,15,7,20,3};
        TreeNode root = buildTree(inorder,postorder);
        System.out.println(root.val);
    }

    static int postIndex;
    static Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    // 中序定区间长，后序找根建树
    private static TreeNode build(int[] inorder, int[] postorder, int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int index = inorderIndexMap.get(rootVal);

        // 先构右子树，再构左子树
        root.right = build(inorder, postorder, index + 1, inRight);
        root.left = build(inorder, postorder, inLeft, index - 1);

        return root;
    }
}
