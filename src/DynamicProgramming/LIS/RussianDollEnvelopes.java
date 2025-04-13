package DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println("Maximum number of envelopes Russian doll can put one inside the other: " + maxEnvelopes(envelopes));

    }

    public static int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b)-> a[0]!=b[0] ? a[0] - b[0] : b[1] - a[1]);

        List<Integer> temp = new ArrayList<>();
        temp.add(envelopes[0][1]);

        for(int i = 1; i < n; i++){

            if(envelopes[i][1] > temp.get(temp.size() - 1)){
                temp.add(envelopes[i][1]);
            }else{
                int idx = findInsertPosition(temp, envelopes[i][1]);

                temp.set(idx, envelopes[i][1]);
            }
        }

        return temp.size();
    }

    public static int findInsertPosition(List<Integer> temp, int target){

        int start = 0;
        int end = temp.size()-1;

        while(start < end){

            int mid = start + (end - start)/2;
            if(temp.get(mid) == target){
                return mid;
            }else if(target > temp.get(mid)){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        return start;
    }
}
