package month09.day0929;

import java.util.Arrays;
public class MyStack<T> {
    private Object[] stack;
    private int size;
    MyStack() {
        stack = new Object[10];//初始容量为10
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public T peek() {
        T t = null;
        if (size > 0)
            t = (T) stack[size - 1];
        return t;
    }
    public void push(T t) {
        expandCapacity(size + 1);
        stack[size] = t;
        size++;
    }
    public T pop() {
        T t = peek();
        if (size > 0) {
            stack[size - 1] = null;
            size--;
        }
        return t;
    }
    public void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 3 / 2 + 1;//每次扩大50%
            stack = Arrays.copyOf(stack, size);
        }
    }
}

class ArrayStack {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.push("java");
        stack.push("is");
        stack.push("beautiful");
        stack.push("language");
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }
}
