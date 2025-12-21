package suixianglu.tree;

public class L101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSym(root.left, root.right);
    }

    public static boolean isSym(TreeNode left, TreeNode right) {
        // 左右子树都为NULL，则为TRUE
        if (left == null && right == null)
            return true;

        // 左右子树都不为NULL && 左右子树的值相等 && 左子树的左子树与右子树的右子树对称 && 左子树的右子树与右子树的左子树对称，则为TRUE
        if (left != null && right != null && left.val == right.val && isSym(left.left, right.right) && isSym(left.right, right.left))
            return true;
        return false;
    }

}