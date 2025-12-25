package suixianglu.tree;

public class L404 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(sumOfLeftLeaves(root));
    }


    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        return sumOfLeaves(root, 0);
    }

    public static int sumOfLeaves(TreeNode root, int sum) {
        if (root == null)
            return 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;
        sum += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        return sum;
    }
}
