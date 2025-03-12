package Stack.MathOperations;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = "1+(4+5+2)-3+(6+8)";
        System.out.println("Output= " + calculate(s));
    }

    public static int calculate(String s) {
        int n= s.length();
        int num=0;
        int ans=0;
        int sign=1;
        Stack<Integer> stack= new Stack<>();

        //"12+2-1-(3+4)+3"

        for(int i=0; i<n; i++){

            if(Character.isDigit(s.charAt(i))){
                num= num*10 + (s.charAt(i)-'0');
            }else if(s.charAt(i)=='+'){
                ans= ans+num*sign;
                num=0;
                sign=1;
            }else if(s.charAt(i)=='-'){
                ans= ans+num*sign;
                num=0;
                sign=-1;
            }else if(s.charAt(i)=='('){
                stack.push(ans);
                stack.push(sign);
                num=0;
                ans=0;
                sign=1;
            }else if(s.charAt(i)==')'){
                ans=ans+num*sign;
                num=0;
                sign=1;

                int paraAns = ans*stack.pop();
                ans= stack.pop()+paraAns;
            }

        }

        ans+=num*sign;

        return ans;

    }
}
