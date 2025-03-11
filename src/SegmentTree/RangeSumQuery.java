package SegmentTree;

// [1,3,5,2,7,8]
public class RangeSumQuery {

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,7,8};
        int n= arr.length;
        segmentTree obj = new segmentTree(arr);

        obj.buildSegTree(arr, 0, 0, n-1);
        obj.updateSegTree(3, 5, arr, 0, 0, n-1);
        System.out.println("sum is: " + obj.rangeSum(2, 4, arr, 0, 0, n-1));
    }
}

class segmentTree{

    int size;
    int[] segArr;
    public segmentTree(int[] arr){
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

        segArr[i] = segArr[2*i + 1] + segArr[2*i + 2];
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


        segArr[i] = segArr[2*i + 1] + segArr[2*i + 2];
        return;
    }

    public int rangeSum(int start, int end, int[] arr, int i, int left, int right){


        if(right < start || left > end){
            return 0;
        }
        if(start <= left && right <= end){
            return segArr[i];
        }

        int mid = left + (right - left)/2;

        return rangeSum(start, end, arr, 2*i+1, left, mid) + rangeSum(start, end, arr, 2*i+2, mid + 1, right);

    }


}
