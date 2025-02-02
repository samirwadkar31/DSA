package DifferenceArray;

public class ZeroArrayTransformation1 {
    public static void main(String[] args) {
        int[] nums= {1,0,1};
        int[][] queries= {{0,2}};
        System.out.println(isZeroArray(nums, queries));
    }

    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] freq = new int[n+1];

        //step1: L+Value & R+1-Value
        for(int[] q : queries) {
            freq[q[0]]++;
            freq[q[1]+1]--;
        }

        //step2: Prefix Sum

        for(int i = 1; i < n; i++) {
          freq[i]+=freq[i-1];
        }

        //step3: Check Condition

        for(int i = 1; i < n; i++) {
            if(nums[i]>freq[i]) return false;
        }

        return true;
    }
}


