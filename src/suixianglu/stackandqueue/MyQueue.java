package suixianglu.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MyQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        int res = stack2.pop();
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
        return res;
    }

    public int peek() {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        int res = stack2.peek();
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
        return res;
    }

    public boolean empty() {
        if (stack1.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}