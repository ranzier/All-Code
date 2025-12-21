package suixianglu.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L429 {
    public static void main(String[] args) {
        Node root = new Node(1);
        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                if (queue.peek().children != null) {
                    for (Node kid : queue.peek().children)
                        queue.offer(kid);
                }
                list.add(queue.poll().val);
                size--;
            }
            result.add(list);
        }

        return result;
    }
}
