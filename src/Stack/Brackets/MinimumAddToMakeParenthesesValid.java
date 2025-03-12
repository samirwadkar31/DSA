package Stack.Brackets;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        String s = ")))((())())";
        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {

        int n = s.length();
        int count = 0;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
                count++;
            }else if(ch == ')'){

                if(stack.isEmpty()){
                    count++;
                }else{
                    stack.pop();
                    count--;
                }
            }
        }
        return count;
    }

}
