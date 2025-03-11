package SegmentTree;

public class MinRangeQuery {
    public static void main(String[] args) {
        int[] arr = {1,3,5,2,7,8};
        int n= arr.length;
        segmentTreeMinQuery obj = new segmentTreeMinQuery(arr);

        obj.buildSegTree(arr, 0, 0, n-1);
//        obj.updateSegTree(3, 5, arr, 0, 0, n-1);
        System.out.println("Min is: " + obj.rangeMin(2, 4, arr, 0, 0, n-1));
    }
}

class segmentTreeMinQuery{

    int size;
    int[] segArr;
    public segmentTreeMinQuery(int[] arr){
        this.size= 4*arr.length;
        this.segArr = new int[size];
    }

    public void buildSegTree(int[] arr, int i, int left, int right){

        if(left == right){
            segArr[i] = arr[left]; // left or right anything would work
            return;
        }

        int mid = left + (right - left)/2;

        buildSegTree(arr, 2*i+1, left, mid);
        buildSegTree(arr, 2*i+2, mid+1, right);

        segArr[i] = Math.min(segArr[2*i + 1], segArr[2*i + 2]);
        return;
    }

    public void updateSegTree(int index, int value, int[] arr, int i, int left, int right){

        if(left == right){
            segArr[i] = value;
            return;
        }
        int mid = left + (right - left)/2;

        if(index<=mid){
            updateSegTree(index, value, arr, 2*i+1, left, mid);
        }else{
            updateSegTree(index, value, arr, 2*i+2, mid+1, right);
        }


        segArr[i] = Math.min(segArr[2*i + 1], segArr[2*i + 2]);
        return;
    }

    public int rangeMin(int start, int end, int[] arr, int i, int left, int right){


        if(right < start || left > end){
            return Integer.MAX_VALUE;
        }
        if(start <= left && right <= end){
            return segArr[i];
        }

        int mid = left + (right - left)/2;

        return Math.min(rangeMin(start, end, arr, 2*i+1, left, mid), rangeMin(start, end, arr, 2*i+2, mid + 1, right));

    }
}
