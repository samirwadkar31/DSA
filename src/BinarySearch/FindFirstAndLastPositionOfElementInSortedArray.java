package BinarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums={5,7,8,8,8,8,8,10};
        int target= 8;
        int[] res= searchRange(nums, target);

        for(int num: res){
            System.out.println(num);
        }
    }

    public static int[] searchRange(int[] nums, int target) {

        int start=0;
        int end= nums.length-1;
        int mid=0;

        int[] ans= {-1,-1};

        while(start<=end){
            mid= start+(end-start)/2;

            if(nums[mid]==target){
                ans[0]=mid;
                end=mid-1;

            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        start=0;
        end=nums.length-1;
        mid=0;

        while(start<=end){
            mid= start+(end-start)/2;

            if(nums[mid]==target){
                ans[1]=mid;
                start=mid+1;

            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        return ans;

    }
}
