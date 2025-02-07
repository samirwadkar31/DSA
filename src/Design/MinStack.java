package Design;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        MinStackTest minStack = new MinStackTest();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("Minimum: " + minStack.getMin()); // Output: -3
        minStack.pop();

        System.out.println("Top: " + minStack.top()); // Output: 0
        System.out.println("Minimum: " + minStack.getMin()); // Output: -2

    }
}

class MinStackTest {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    int size;

    public MinStackTest() {
        stack= new Stack<>();
        minStack= new Stack<>();
        size=0;
    }

    public void push(int val) {
        if(size==0){
            stack.push(val);
            minStack.push(val);
            size++;
        }else{
            stack.push(val);
            int min= minStack.peek();
            minStack.push(Math.min(val, min));
            size++;
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        size--;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

