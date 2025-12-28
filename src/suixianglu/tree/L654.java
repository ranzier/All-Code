package suixianglu.tree;

public class L654 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = constructMaximumBinaryTree(nums);
        System.out.println(root.val);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public static TreeNode construct(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = construct(nums, left, maxIndex - 1);
        root.right = construct(nums, maxIndex + 1, right);
        return root;
    }
}
