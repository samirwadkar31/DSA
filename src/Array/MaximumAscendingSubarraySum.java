package Array;

public class MaximumAscendingSubarraySum {
    public static void main(String[] args) {
        int[] nums= {12,17,15,13,10,11,12};
        System.out.println(maxAscendingSum(nums));
    }

    public static int maxAscendingSum(int[] nums) {

        int n= nums.length;
        int max=0;
        int sum=0;

        for(int i=0; i<n; i++){
            if(i==0){
                sum=sum+nums[i];
            }else if(nums[i]>nums[i-1]){
                sum=sum+nums[i];
            }else{
                sum=nums[i];
            }

            max= Math.max(max, sum);
        }

        return max;
    }
}
