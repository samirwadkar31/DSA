package Greedy;

public class JumpGameGreedy {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {

        int finalPosition = nums.length-1;

        for(int index= nums.length-2; index>=0; index--){

            if(index+nums[index]>=finalPosition){
                finalPosition=index;               // shifting final position to the left
            }
        }

        return finalPosition==0;

    }
}

