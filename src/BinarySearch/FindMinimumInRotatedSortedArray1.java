package BinarySearch;

public class FindMinimumInRotatedSortedArray1 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        // nums = [11,13,15,17]
        // nums = [4,5,6,7,1,2,3]
        System.out.println("Smallest minimum number inr rotated sorted array is: " + findMin(nums));
    }

    public static int findMin(int[] nums) {
        int start=0;
        int end= nums.length-1;

        while(start<end){
            int mid= start+(end-start)/2;

            if(nums[mid]>nums[end]){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return nums[start];

    }
}
