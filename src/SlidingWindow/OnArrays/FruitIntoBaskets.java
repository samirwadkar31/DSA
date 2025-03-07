package SlidingWindow.OnArrays;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {

        int[] fruits= {1,1,1,2,2,2,3,3,3};

        System.out.println("maximum number of fruits you can pick: "+ totalFruit(fruits));

    }

    public static int totalFruit(int[] fruits) {

        int n= fruits.length;

        Map<Integer, Integer> map= new HashMap<>();
        int maxFruits= 0;

        int start=0;

        for(int end=0; end<n; end++){

            map.put(fruits[end], map.getOrDefault(fruits[end], 0)+1);

            while(map.size()>2){

                map.put(fruits[start], map.getOrDefault(fruits[start],0)-1);

                if(map.get(fruits[start])==0){
                    map.remove(fruits[start]);
                }

                start++;
            }

            maxFruits= Math.max(maxFruits, end-start+1);
        }

        return maxFruits;
    }
}
