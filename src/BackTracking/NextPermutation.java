package BackTracking;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums= {1,2,3};
        //int[] nums= {3,2,1};

        int[] ans= nextPermutation(nums);

        for(int num: ans) {
            System.out.println(num);
        }
    }

    public static int[] nextPermutation(int[] nums) {
        int n= nums.length;

        int idx1= -1;
        for(int i=n-1; i>0; i--){
            if(nums[i]>nums[i-1]){
                idx1=i-1;
                break;
            }
        }

        int idx2=-1;
        if(idx1!=-1){
            for(int i=n-1; i>=idx1+1; i--){
                if(nums[i]>nums[idx1]){
                    idx2=i;
                    break;
                }
            }
            swap(nums, idx1, idx2);
        }

        reverse(nums, idx1+1, n-1);

        return nums;
    }

    public static void swap(int[] nums, int idx1, int idx2){
        int temp= nums[idx1];
        nums[idx1]= nums[idx2];
        nums[idx2]= temp;
    }

    public static void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp= nums[start];
            nums[start]= nums[end];
            nums[end]= temp;
            start++;
            end--;
        }
    }
}
