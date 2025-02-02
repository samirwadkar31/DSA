package TwoPointers;

import java.util.Arrays;

public class TwoSum2InputArrayIsSorted {
    public static void main(String[] args) {
        int[] numbers= {2,7,11,15};
        int target=9;
        int[] res = twoSum(numbers, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int start=0;
        int end= numbers.length-1;
        int[] ans= {-1,-1};
        while(start<=end){
            int sum=numbers[start]+numbers[end];
            if(sum>target){
                end=end-1;
            }else if(sum<target){
                start=start+1;
            }else{
                return new int[]{start+1, end+1};
            }
        }

        return ans;
    }
}
