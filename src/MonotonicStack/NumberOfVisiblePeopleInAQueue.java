package MonotonicStack;

import java.util.Stack;

public class NumberOfVisiblePeopleInAQueue {

    public static void main(String[] args) {
        int[] heights = {10,6,8,5,11,9};
        int[] res = canSeePersonsCount(heights);

        for(int num: res){
            System.out.print(num + " ");
        }
    }

    public static int[] canSeePersonsCount(int[] heights) {

        int n = heights.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack();

        for(int i = n - 1; i >= 0; i--){
            int count = 0;

            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                count++;
            }

            if(!stack.isEmpty()) count++;

            stack.push(heights[i]);

            ans[i] = count;
        }

        return ans;
    }
}
