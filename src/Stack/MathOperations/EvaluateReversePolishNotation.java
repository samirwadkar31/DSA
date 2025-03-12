package Stack.MathOperations;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Output= " + evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {

        int n = tokens.length;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){

            if(tokens[i].equals("+")){

                stack.push(stack.pop() + stack.pop());

            }else if(tokens[i].equals("-")){

                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);

            }else if(tokens[i].equals("/")){

                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);

            }else if(tokens[i].equals("*")){
                stack.push(stack.pop() * stack.pop());

            }else {

                stack.push(Integer.valueOf(tokens[i]));

            }
        }

        return stack.pop();
    }

}
