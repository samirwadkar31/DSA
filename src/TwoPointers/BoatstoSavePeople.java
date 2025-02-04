package TwoPointers;

import java.util.Arrays;

public class BoatstoSavePeople {
    public static void main(String[] args) {
        int[] people= {3,2,2,1};
        int limit= 3;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int start=0;
        int end= people.length-1;
        int boats=0;

        while(start<=end){
            int sumOfWeights= people[start]+people[end];

            if(sumOfWeights>limit){
                boats++;
                end--;
            }else{
                boats++;
                start++;
                end--;
            }
        }

        return boats;
    }
}
