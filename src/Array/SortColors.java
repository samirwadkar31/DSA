package Array;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for(int num: nums){
            System.out.print(num + " ");
        }
    }

    public static void sortColors(int[] nums) {
        // nums= [1,1,0,0,1,2]
        int i=0;
        int j=0;
        int k= nums.length-1;

        while(j<=k){
            if(nums[j]==0){
                swap(nums, j, i);
                i++;
                j++;
            }else if(nums[j]==2){
                swap(nums, j, k);
                k--;
            }else{
                j++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
