package Stack;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};

        int[] res = asteroidCollision(asteroids);

        for(int ast: res){
            System.out.print(ast + " ");
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        int n= asteroids.length;

        for(int i=0; i<n; i++){

            if(asteroids[i]>0){
                stack.push(asteroids[i]);
            }else{
                while(stack.size()!=0 && stack.peek()<Math.abs(asteroids[i]) && stack.peek()>0){
                    stack.pop();
                }
                if(stack.size()==0 || stack.peek()<0){
                    stack.push(asteroids[i]);
                }else if(stack.peek()==Math.abs(asteroids[i])){
                    stack.pop();
                }
            }

        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);  // Copy elements from the stack to the result array
        }

        return result;

    }
}
