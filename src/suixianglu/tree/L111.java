package suixianglu.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class L111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(minDepth(root));
    }

    // 递归遍历
    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null && root.right != null)
            return minDepth(root.right) + 1;
        if (root.right == null && root.left != null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    // 层序遍历,遍历的时候有一个结点没有左右子节点，则返回
    public static int minDepth1(TreeNode root) {
        int result = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                if (queue.peek().left == null && queue.peek().right == null)
                    return result + 1;
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                queue.poll();
                size--;
            }
            result++;
        }
        return result;
    }
}
