package MonotonicStack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] res = nextGreaterElement(nums1, nums2);
        for(int i = 0; i< nums1.length; i++){
            System.out.println(nums1[i] + "'s Next Greater Element -> " + res[i]);
        }

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map= new HashMap<>();
        Stack<Integer> stack= new Stack<>();
        int[] ans = new int[nums1.length];

        for(int i=nums2.length-1; i>=0; i--){

            while(!stack.isEmpty() && nums2[i]> stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                map.put(nums2[i], -1);
            }else{
                map.put(nums2[i], stack.peek());
            }

            stack.push(nums2[i]);
        }

        for(int i=0; i<nums1.length; i++){
            ans[i]= map.get(nums1[i]);
        }

        return ans;
    }
}
