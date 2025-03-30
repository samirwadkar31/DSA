package Design;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class FindingMKAverage {
    public static void main(String[] args) {
        MKAverage obj = new MKAverage(3, 1);
        obj.addElement(3);        // current elements are [3]
        obj.addElement(1);        // current elements are [3,1]
        System.out.println(obj.calculateMKAverage()); // return -1, because m = 3 and only 2 elements exist.
        obj.addElement(10);       // current elements are [3,1,10]
        System.out.println(obj.calculateMKAverage());// The last 3 elements are [3,1,10].
        // After removing smallest and largest 1 element the container will be [3].
        // The average of [3] equals 3/1 = 3, return 3
        obj.addElement(5);        // current elements are [3,1,10,5]
        obj.addElement(5);        // current elements are [3,1,10,5,5]
        obj.addElement(5);        // current elements are [3,1,10,5,5,5]
        System.out.println(obj.calculateMKAverage()); // The last 3 elements are [5,5,5].
        // After removing smallest and largest 1 element the container will be [5].
        // The average of [5] equals 5/1 = 5, return 5
    }
}

class MKAverage {

    int m;
    int k;
    Queue<Integer> queue;
    TreeMap<Integer, Integer> small;
    TreeMap<Integer, Integer> middle;
    TreeMap<Integer, Integer> large;
    long middleSum;
    int smallSize;
    int largeSize;


    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.queue = new LinkedList<>();
        this.small = new TreeMap<>();
        this.middle = new TreeMap<>();
        this.large = new TreeMap<>();
        middleSum = 0;
        smallSize = 0;
        largeSize = 0;

    }

    public void addElement(int num) {

        queue.add(num);

        if(!small.isEmpty() && num <= small.lastKey()){
            small.put(num, small.getOrDefault(num, 0) +1);
            smallSize++;
        }else if(!large.isEmpty() && num >= large.firstKey()){
            large.put(num, large.getOrDefault(num, 0) +1);
            largeSize++;
        }else{
            middle.put(num, middle.getOrDefault(num, 0) +1);
            middleSum += num;
        }

        if(queue.size() < m) return;

        if(queue.size() == m){
            balance();
        }

        if(queue.size() > m){
            int oldNum = queue.poll();

            if(!small.isEmpty() && small.containsKey(oldNum)){
                small.put(oldNum, small.getOrDefault(oldNum, 0) - 1);
                smallSize--;
                if(small.get(oldNum) == 0) small.remove(oldNum);
            }else if(!large.isEmpty() && large.containsKey(oldNum)){
                large.put(oldNum, large.getOrDefault(oldNum, 0) - 1);
                largeSize--;
                if(large.get(oldNum) == 0) large.remove(oldNum);
            }else if(!middle.isEmpty() && middle.containsKey(oldNum)){
                middle.put(oldNum, middle.getOrDefault(oldNum, 0) - 1);
                middleSum -= oldNum;
                if(middle.get(oldNum) == 0) middle.remove(oldNum);
            }

            balance();
        }
    }

    public void balance(){

        while(smallSize < k){
            int smallNum = middle.firstKey();
            middle.put(smallNum, middle.getOrDefault(smallNum, 0) - 1);
            if(middle.get(smallNum) == 0) middle.remove(smallNum);
            middleSum -= smallNum;
            smallSize++;
            small.put(smallNum, small.getOrDefault(smallNum, 0) + 1);
        }

        while(largeSize < k){
            int largeNum = middle.lastKey();
            middle.put(largeNum, middle.getOrDefault(largeNum, 0) - 1);
            if(middle.get(largeNum) == 0) middle.remove(largeNum);
            middleSum -= largeNum;
            largeSize++;
            large.put(largeNum, large.getOrDefault(largeNum, 0) + 1);
        }

        while(smallSize > k){
            int smallNum = small.lastKey();
            small.put(smallNum, small.getOrDefault(smallNum, 0) - 1);
            if(small.get(smallNum) == 0) small.remove(smallNum);
            smallSize--;
            middle.put(smallNum, middle.getOrDefault(smallNum, 0) + 1);
            middleSum += smallNum;
        }

        while(largeSize > k){
            int largeNum = large.firstKey();
            large.put(largeNum, large.getOrDefault(largeNum, 0) - 1);
            if(large.get(largeNum) == 0) large.remove(largeNum);
            largeSize--;
            middle.put(largeNum, middle.getOrDefault(largeNum, 0) + 1);
            middleSum += largeNum;
        }
    }

    public int calculateMKAverage() {

        if(queue.size() < m) return -1;

        return (int)(middleSum/(m - 2*k));
    }

}
