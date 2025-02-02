package Array;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int m=3;
        int n=3;
        int[] nums1= {1,2,3,0,0,0};
        int[] nums2= {2,5,6};
        int[] ans= merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(ans));
    }
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int p1= m-1;
        int p2= n-1;

        int j= m+n-1;

        while(p1>=0 && p2>=0){

            if(nums1[p1]>nums2[p2]){
                nums1[j]=nums1[p1];
                p1--;
                j--;
            }else{
                nums1[j]=nums2[p2];
                p2--;
                j--;
            }

        }

        while(p2>=0){
            nums1[j]=nums2[p2];
            p2--;
            j--;
        }

        return nums1;
    }
}
