package Intervals;

import java.util.List;
import java.util.ArrayList;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals={{1,3},{6,9}};
        int[] newInterval= {2,5};

        int[][] ans= insert(intervals, newInterval);

        for(int[] interval: ans){
            System.out.println(interval[0] + ", " + interval[1]);
        }

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> tempList = new ArrayList<>();
        boolean flag= false;

        for(int[] interval: intervals){
            if(interval[0]>newInterval[0] && flag==false){
                tempList.add(newInterval);
                flag=true;
            }
            tempList.add(interval);
        }

        if(flag==false) tempList.add(newInterval);

        List<int[]> res = new ArrayList<>();

        for(int i=0; i<tempList.size(); i++){
            int[] currInterval= tempList.get(i);

            if(res.isEmpty() || currInterval[0]>res.get(res.size() - 1)[1]){
                res.add(currInterval);
            }else if(currInterval[0]<=res.get(res.size() - 1)[1]){
                res.get(res.size() - 1)[1]= Math.max(res.get(res.size() - 1)[1], currInterval[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
