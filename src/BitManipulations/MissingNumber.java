package BitManipulations;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums= {3,0,1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {

        int missingXOR=0;

        for(int i=0; i<=nums.length; i++){
            missingXOR=missingXOR^i;
        }

        for(int i=0; i<nums.length; i++){
            missingXOR=missingXOR^nums[i];
        }

        return missingXOR;
    }

}
