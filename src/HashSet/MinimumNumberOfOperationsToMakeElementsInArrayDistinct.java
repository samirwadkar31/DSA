package HashSet;

import java.util.HashSet;
import java.util.Set;

public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,3,3,5,7};
        //int[] nums = {4,5,6,4,4}; Reason why ceil is required
        System.out.println("Minimum Number Of Operations To Make Elements In Array Distinct : " + minimumOperations(nums));
    }

    public static int minimumOperations(int[] nums) {

        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int operations = 0;

        for(int i = n - 1; i >= 0; i--){

            if(set.contains(nums[i])){
                operations = (int)Math.ceil((i + 1)/3.0);
                return operations;
            }
            set.add(nums[i]);
        }

        return operations;
    }
}
