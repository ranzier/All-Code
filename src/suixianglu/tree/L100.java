package suixianglu.tree;

public class L100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // 两树都为NULL，则为TURE
        if (p == null && q == null)
            return true;

        // 两树都不为NULL && 两树的结点的值相等 && 两树的左子树相等 && 两树的右子树相等，则为TRUE
        if (p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
            return true;
        return false;
    }

}
