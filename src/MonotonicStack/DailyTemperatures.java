package MonotonicStack;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(temperatures);
        for(int i = 0; i< temperatures.length; i++){
            System.out.println(temperatures[i] + " temperature day has to wait for -> " + res[i] + " days");
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n-1; i >=0; i--) {

            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if(stack.isEmpty()){
                result[i]=0;
            }else{
                result[i]= stack.peek()-i;
            }

            stack.push(i);
        }
        return result;
    }
}
