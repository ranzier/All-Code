package suixianglu.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {

    Deque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        return queue.pollLast();
    }

    public int top() {
        return queue.peekLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
