package suixianglu.tree;

public class L701 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(insertIntoBST(root, 5).val);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (root.left == null && val < root.val)
            root.left = new TreeNode(val);
        if (root.right == null && val > root.val)
            root.right = new TreeNode(val);
        if (val < root.val)
            insertIntoBST(root.left, val);
        if (val > root.val)
            insertIntoBST(root.right, val);
        return root;
    }
}