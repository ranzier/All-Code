package suixianglu.tree;

import java.util.List;

public class L559 {
    public static void main(String[] args) {
        Node root = new Node(1);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(Node root) {
        if (root == null)
            return 0;

        int depth = 0;
        for (Node kid : root.children) {
            depth = Math.max(depth, maxDepth(kid));
        }
        return depth + 1;
    }
}
