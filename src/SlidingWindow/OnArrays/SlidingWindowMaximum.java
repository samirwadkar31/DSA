package SlidingWindow.OnArrays;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] ans = maxSlidingWindow(nums, k);

        for(int num: ans) System.out.print(num + " ");
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n= nums.length;
        List<Integer> ans= new ArrayList<>();
        Deque<Integer> dq= new LinkedList<>();

        for(int i=0; i<n; i++){

            while(!dq.isEmpty() && i-dq.peekFirst()>=k){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[i]>nums[dq.peekLast()]){
                dq.removeLast();
            }

            dq.addLast(i);

            if(i>=k-1) ans.add(nums[dq.peekFirst()]);
        }

        int[] res= new int[ans.size()];

        for(int i=0; i<ans.size(); i++){
            res[i]= ans.get(i);
        }
        return res;
    }
}
