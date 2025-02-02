package DifferenceArray;

public class ZeroArrayTransformation2 {
    public static void main(String[] args) {
        int[] nums= {2,0,2};
        int[][] queries= {{0,2,1},{0,2,1},{1,1,3}};

        System.out.println(minZeroArray(nums, queries));

    }

    public static int minZeroArray(int[] nums, int[][] queries) {
        // edge case nums already [0] or [0,0,0]
        boolean isZeroArray = true;

        for (int num : nums) {
            if (num != 0) {
                isZeroArray = false;
                break;
            }
        }
        if (isZeroArray)  return 0;

        int start=0;
        int end= queries.length-1;
        int result= -1;

        while(start<=end){
            int mid= start+(end-start)/2;

            if(isZeroArray(nums, queries, mid)){
                result=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        if(result==-1) return -1;
        return result+1;
    }

    public static boolean isZeroArray(int[] nums, int[][] queries, int mid) {
        int n = nums.length;
        int[] freq = new int[n+1];

        for(int i=0; i<=mid; i++) {
            int[] q= queries[i];
            freq[q[0]]+=q[2];
            freq[q[1]+1]-=q[2];
        }

        for(int i = 1; i < n; i++) {
            freq[i] += freq[i-1];
            if(freq[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }

}
