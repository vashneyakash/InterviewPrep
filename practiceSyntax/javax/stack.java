package javax;

import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(23);
        stack.push(45);
        stack.push(98);
        stack.push(12);
        stack.push(34);

        while(stack.peek() != 45) {
            System.out.println("stack.pop() = " + stack.pop());
        }
        System.out.println("stack.isEmpty() = " + stack.isEmpty());
        stack.clear();

        while (!stack.empty()) {
            System.out.println("stack.pop() = " + stack.pop());
            System.out.println("stack.isEmpty() = " + stack.isEmpty());
        }
    }
}
