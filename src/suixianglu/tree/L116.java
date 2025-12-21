package suixianglu.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class L116 {
    public static void main(String[] args) {
        PerfectNode root = new PerfectNode(1);
        PerfectNode perfectNode = connect(root);
        System.out.println(perfectNode.val);
    }


    public static PerfectNode connect(PerfectNode root) {
        Deque<PerfectNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                if (size == 1) {
                    queue.peek().next = null;
                    queue.poll();
                } else {
                    PerfectNode temp = queue.poll();
                    temp.next = queue.peek();
                }
                size--;
            }
        }
        return root;
    }
}
