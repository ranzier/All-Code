package suixianglu.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class L42 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = height[stack.pop()];
                if (stack.isEmpty())
                    continue;

                int left = height[stack.peek()];
                int len = i - stack.peek() - 1;
                int heights = Math.min(left, height[i]) - bottom;
                water += heights * len;
            }
            stack.push(i);
        }

        return water;
    }
}
