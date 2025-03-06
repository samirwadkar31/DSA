package BinarySearch.OnRange;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums={7,2,5,10,8};
        int k=2;
        System.out.println("minimized largest sum of the split: "+splitArray(nums,k));
    }

    public static int splitArray(int[] nums, int k) {
        int n= nums.length;
        int sum=0;
        int largest_element=0;

        for(int i=0; i<n; i++){
            sum+=nums[i];
            largest_element= Math.max(largest_element, nums[i]);
        }

        int start= largest_element;
        int end= sum;

        while(start<end){

            int mid= start+(end-start)/2;

            if(split(nums, k, mid)){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;
    }

    private static boolean split(int[] nums, int k, int mid){
        int sum=0;
        int count=1;

        for(int i=0; i<nums.length; i++){
            sum+=nums[i];

            if(sum> mid){
                count++;
                sum=nums[i];
            }
        }

        return count<=k;
    }
}
