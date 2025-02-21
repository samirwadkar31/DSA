package Intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums= {0,1,2,4,5,7};
        List<String> ans= summaryRanges(nums);
        for(String str: ans){
            System.out.println(str);
        }
    }

    public static List<String> summaryRanges(int[] nums) {

        List<String> ans= new ArrayList<>();
        int n= nums.length;

        for(int i=0; i<n; i++){
            int start=nums[i];

            while(i+1<n && nums[i]+1==nums[i+1]){
                i++;
            }

            if(start!=nums[i]){
                String range= Integer.toString(start)+"->"+Integer.toString(nums[i]);
                ans.add(range);
            }else{
                String range= Integer.toString(start);
                ans.add(range);
            }

        }

        return ans;
    }
}
