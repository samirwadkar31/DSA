package BinarySearch;

public class SingleElementInSortedArray {
    public static void main(String[] args) {

        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println("Single element is: " + singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {

        int n= nums.length;
        int start=0;
        int end= n-1;

        while(start<end){
            int mid= start+(end-start)/2;
            int diff= end - mid;

            if(nums[mid]==nums[mid+1]){

                if(diff % 2 == 0){
                    start=mid+2;
                }else{
                    end=mid-1;
                }
            }else{

                if(diff % 2 == 0){
                    end=mid;

                }else{
                    start=mid+1;
                }

            }
        }
        return nums[start];
    }
}
