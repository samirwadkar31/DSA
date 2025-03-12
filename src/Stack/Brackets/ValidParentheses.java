package Stack.Brackets;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        // eg "([{}()])" true
        // eg "([{}(]))" false // opening brackets must be closed first
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        int n= s.length();

        if(n%2!=0){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<n; i++){

            if(s.charAt(i)=='('){
                stack.push(')');
            }else if(s.charAt(i)=='['){
                stack.push(']');
            }else if(s.charAt(i)=='{'){
                stack.push('}');
            }else if(stack.isEmpty() || s.charAt(i)!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
