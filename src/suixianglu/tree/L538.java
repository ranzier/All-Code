package suixianglu.tree;

public class L538 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(8);
        System.out.println(convertBST(root).val);
    }

    static int sum;
    public static TreeNode convertBST(TreeNode root) {
        sum = 0;
        BST(root);
        return root;
    }

    public static void BST(TreeNode root) {
        if (root == null)
            return;
        BST(root.right);
        sum += root.val;
        root.val = sum;
        BST(root.left);
    }
}
