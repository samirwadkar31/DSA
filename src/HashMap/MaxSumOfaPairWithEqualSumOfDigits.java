package HashMap;
import java.util.Map;
import java.util.HashMap;

public class MaxSumOfaPairWithEqualSumOfDigits {

    public static void main(String[] args) {
        int[] nums = {18,43,36,13,7,63,5,9,18,3};
        // output: 99
        System.out.println("Max sum pair : " + maximumSum(nums));
    }

    public static int maximumSum(int[] nums) {

        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for(int i = 0; i < n; i++){
            int sum = sumOfDigits(nums[i]);
            if(!map.containsKey(sum)){
                map.put(sum, nums[i]);
            }else{
                int oldSum = map.get(sum);
                map.put(sum, Math.max(oldSum, nums[i]));
                ans = Math.max(ans, oldSum + nums[i]);
            }
        }

        return ans;
    }

    public static int sumOfDigits(int num){
        int sum = 0;
        while(num!= 0){
            sum += num % 10;
            num = num/10;
        }

        return sum;
    }
}
