package MonotonicStack;

import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        // expected output : 2,3,4,-1,4 circular loop for last index greater element
        int[] res = nextGreaterElements(nums);

        for(int i = 0; i< nums.length; i++){
            System.out.println(nums[i] + "'s Next Greater Element -> " + res[i]);
        }
    }

    public static int[] nextGreaterElements(int[] nums) {

        int n= nums.length;

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for( int i=n*2-1; i>=0; i--){

            int index=i%n;

            while(!stack.isEmpty() && nums[index]>=nums[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()) ans[index]=-1;
            else ans[index]= nums[stack.peek()];

            stack.push(index);
        }

        return ans;
    }
}
