package suixianglu.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L1047 {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        // 使用队列去重
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!deque.isEmpty() && deque.peekLast() == c) {
                deque.pollLast();
                continue;
            }
            deque.addLast(c);
        }

        // 将队列元素转换成字符串
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}
