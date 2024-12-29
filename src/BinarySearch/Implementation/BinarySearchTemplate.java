package BinarySearch.Implementation;

public class BinarySearchTemplate {
    public static void main(String[] args) {
        // array must be sorted-This is the condition for binary search
        // TC- O(log(n))
        // SC- O(n)
        int[] nums= {2,4,7,8,9,15,18};
        int target= 15;

        System.out.println(" Index of target "+target+" is "+binarySearch(nums, target));

    }

    public static int binarySearch(int[] nums, int target){
        int start=0;
        int end= nums.length-1;

        while(start<=end){
            int mid= start + (end-start)/2;

            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start= mid+1;
            }else if(nums[mid]>target){
                end=mid-1;
            }
        }
        return -1;
    }
}
