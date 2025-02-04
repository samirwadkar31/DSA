package Math;

public class FindGCDofArray {
    public static void main(String[] args) {
        int[] nums= {2,5,6,9,10};
        System.out.println(findGCD(nums));
    }
    public static int findGCD(int[] nums) {

        int n= nums.length;
        int max= Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            max= Math.max(max, nums[i]);
            min= Math.min(min, nums[i]);
        }

        return findGCD(max, min);

    }

    public static int findGCD(int max, int min){
        // eg 48, 18
        while(min!=0){
            int temp= min;
            min= max%min;
            max=temp;
        }

        return max;
    }
}
