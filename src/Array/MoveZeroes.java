package Array;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for(int num: nums){
            System.out.print(num + " ");
        }

    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int insertPosition = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                nums[insertPosition] = nums[i];
                insertPosition++;
            }
        }

        while(insertPosition < n){
            nums[insertPosition] = 0;
            insertPosition++;
        }

    }
}
