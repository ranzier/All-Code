package suixianglu.tree;

public class L572 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);
        System.out.println(isSubtree(root, subRoot));
    }

    // 前序遍历root的每个结点与subRoot比较，看是否相同
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSame(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSame(TreeNode p, TreeNode q) {
        // 两树都为NULL，则为TURE
        if (p == null && q == null)
            return true;

        // 两树都不为NULL && 两树的结点的值相等 && 两树的左子树相等 && 两树的右子树相等，则为TRUE
        if (p != null && q != null && p.val == q.val && isSame(p.left, q.left) && isSame(p.right, q.right))
            return true;
        return false;
    }
}
