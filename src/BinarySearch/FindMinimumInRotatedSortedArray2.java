package BinarySearch;

public class FindMinimumInRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2};

        System.out.println("Smallest minimum number inr rotated sorted array is: " + findMin(nums));
    }

    public static int findMin(int[] nums) {
        int start=0;
        int end= nums.length-1;

        while(start<end){
            int mid= start+(end-start)/2;

            if(nums[mid]==nums[end]){
                end--;
            }else if(nums[mid]>nums[end]){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return nums[start];
    }
}
