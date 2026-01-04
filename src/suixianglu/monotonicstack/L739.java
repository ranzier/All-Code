package suixianglu.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class L739 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(temperatures);
        for (int i : res)
            System.out.print(i + ",");
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.poll();
            }
            stack.push(i);
        }

        // 栈中还剩下的都置为0
        while (!stack.isEmpty()) {
            res[stack.peek()] = 0;
            stack.poll();
        }
        return res;
    }
}
