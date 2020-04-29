package day0429;

import java.util.Stack;

/**
 * @hurusea
 * @create2020-04-29 10:49
 */
public class MinStack {
    Stack<Integer> A ;
    Stack<Integer> B ;
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if (B.isEmpty() || B.peek() >= x) {
            B.push(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek()))
        B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
