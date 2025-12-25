package suixianglu.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class L513 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        System.out.println(findBottomLeftValue(root));
    }

    public static int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int count = size;
            while (size > 0) {
                if (size == count)
                    res = queue.peek().val;
                if (queue.peek().left != null)
                    queue.add(queue.peek().left);
                if (queue.peek().right != null)
                    queue.add(queue.peek().right);
                queue.poll();
                size--;
            }
        }
        return res;
    }


}
