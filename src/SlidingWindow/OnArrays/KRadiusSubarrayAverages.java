package SlidingWindow.OnArrays;

import java.util.Arrays;

public class KRadiusSubarrayAverages {
    public static void main(String[] args) {
        int[] nums = {7,4,3,9,1,8,5,2,6};
        int k = 3;
        int[] res = getAverages(nums, k);

        for(int num: res){
            System.out.print(num + " ");
        }
    }

    public static int[] getAverages(int[] nums, int k) {

        int n= nums.length;

        int[] ans= new int[n];
        Arrays.fill(ans, -1);

        if(n<2*k+1) return ans;

        long sum= 0;

        for(int i=0; i<2*k+1; i++){
            sum+=nums[i];
        }

        for(int i=k; i<n-k; i++){

            ans[i]= (int)(sum/(2*k+1));

            if(i+k+1<n){
                sum+=nums[i+k+1];
            }

            sum-=nums[i-k];

        }

        return ans;
    }
}
