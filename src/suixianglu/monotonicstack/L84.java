package suixianglu.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class L84 {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] h = new int[n + 2];
        System.arraycopy(heights, 0, h, 1, n);

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int maxArea = 0;

        for (int i = 1; i < h.length; i++) {
            while (h[i] < h[stack.peek()]) {
                int mid = stack.pop();          // 当前高度
                int height = h[mid];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
