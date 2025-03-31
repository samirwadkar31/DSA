package Stack;

import java.util.Stack;

public class ConstructSmallestNumberFromDIString {
    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
        System.out.println("Smallest Number From DI String is: " + smallestNumber(pattern));
    }

    public static String smallestNumber(String pattern) {

        int n = pattern.length();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int num = 1;

        for(int i = 0; i <= n; i++){
            stack.push((char)(num + '0'));
            num++;

            if(i == n || pattern.charAt(i) == 'I'){

                while(!stack.isEmpty()){

                    sb.append(stack.pop());
                }
            }
        }

        return sb.toString();
    }
}
