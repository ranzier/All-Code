package suixianglu.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class L150 {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String str : tokens) {
            // 判断是不是单字符运算符
            if (str.length() == 1 && "+-*/".contains(str)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (str.charAt(0)) {
                    case '+': stack.push(num1 + num2); break;
                    case '-': stack.push(num1 - num2); break;
                    case '*': stack.push(num1 * num2); break;
                    case '/': stack.push(num1 / num2); break;
                }
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

}
