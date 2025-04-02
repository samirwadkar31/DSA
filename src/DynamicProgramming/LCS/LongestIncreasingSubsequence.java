package DynamicProgramming.LCS;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};

        System.out.println("Length of Longest Increasing Subsequence is: " + lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {

        int n = nums.length;

        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for(int i = 1; i < n; i++){

            if(nums[i] > temp.get(temp.size() - 1)){
                temp.add(nums[i]);
            }else{
                int idx = findInsertPosition(temp, nums[i]);

                temp.set(idx, nums[i]);
            }
        }

        return temp.size();
    }

    public static int findInsertPosition(List<Integer> temp, int target){

        int start = 0;
        int end = temp.size()-1;

        while(start < end){

            int mid = start + (end - start)/2;
            if(temp.get(mid) == target){
                return mid;
            }else if(target > temp.get(mid)){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        return start;
    }
}
