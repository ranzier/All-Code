package suixianglu.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class L20 {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (stack.isEmpty() || (c == ')' && stack.pop() != '(') || (c == ']' && stack.pop() != '[') || (c == '}' && stack.pop() != '{'))
                return false;
        }
        return stack.isEmpty();
    }
}
