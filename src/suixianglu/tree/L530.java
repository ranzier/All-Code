package suixianglu.tree;

public class L530 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(getMinimumDifference(root));
    }

    static int min;
    static Integer prev;
    public static int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        prev = null;
        getMin(root);
        return min;
    }

    public static void getMin(TreeNode root) {
        if (root == null)
            return;

        getMin(root.left);
        if (prev != null)
            min = Math.min(min, root.val - prev);
        prev = root.val;
        getMin(root.right);
    }
}
