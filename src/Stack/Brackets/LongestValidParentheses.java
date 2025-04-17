package Stack.Brackets;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = ")()())"; // output 4
        //String s = "()(()"; // output 2

        // here we have to find
        // longest valid parantheses substring length
        // and not the count

        System.out.println("Longest Valid Parentheses length: " + longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}
