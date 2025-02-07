package Design;

import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();

        obj.addNum(1);
        obj.addNum(2);
        System.out.println("Median after adding 1, 2: " + obj.findMedian());

        obj.addNum(3);
        System.out.println("Median after adding 3: " + obj.findMedian());
    }
}

class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap= new PriorityQueue<>((a,b)->b-a);
        minHeap= new PriorityQueue<>();
    }

    public void addNum(int num) {

        if(maxHeap.isEmpty() || num<=maxHeap.peek()){
            maxHeap.offer(num);
        }else if(num>maxHeap.peek()){
            minHeap.offer(num);
        }

        if(maxHeap.size()>minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }else if(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }

    }

    public double findMedian() {

        if(minHeap.size()==maxHeap.size()){
            return (double)(maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            return maxHeap.peek();
        }

    }
}

