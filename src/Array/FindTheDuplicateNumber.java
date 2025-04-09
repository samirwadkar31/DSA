package Array;

public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println("Duplicate number is: " + findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {

        for(int i=0; i<nums.length; i++){
            int val = Math.abs(nums[i]);
            if(nums[val] < 0){
                return val;
            }
            nums[val] = nums[val]*-1;
        }
        return -1;
    }
}
