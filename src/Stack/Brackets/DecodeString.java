package Stack.Brackets;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";

        // stringbuilder 0ms 100%
        System.out.println("Decoded string: " + decodeStringSB(s));
        // string 5ms 12%
        System.out.println("Decoded string: " + decodeStringS(s));
    }

    // stringbuilder
    public static String decodeStringSB(String s) {

        int n = s.length();
        int num = 0;
        StringBuilder currStr = new StringBuilder();

        // if we use stringbuilder operations will be much faster

        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }else if(ch == '['){
                numStack.push(num);
                stringStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            }else if(ch == ']'){
                int digit = numStack.pop();
                StringBuilder prevStr = stringStack.pop();
                for(int j = 0; j < digit; j++){
                    prevStr.append(currStr);
                }
                currStr = prevStr;
            }else{
                currStr.append(ch);
            }
        }

        return currStr.toString();
    }

    public static String decodeStringS(String s) {

        int n = s.length();
        int num = 0;
        String currStr = "";


        Stack<String> stringStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }else if(ch == '['){
                numStack.push(num);
                stringStack.push(currStr);
                num = 0;
                currStr = "";
            }else if(ch == ']'){
                int digit = numStack.pop();
                String prevStr = stringStack.pop();
                for(int j = 0; j < digit; j++){
                    prevStr += currStr;
                }
                currStr = prevStr;
            }else{
                currStr += ch;
            }
        }

        return currStr;
    }
}
