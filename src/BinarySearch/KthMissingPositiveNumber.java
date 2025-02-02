package BinarySearch;

public class KthMissingPositiveNumber {

    public static void main(String[] args) {

        int[] arr= {2,3,4,7,11};
        int k=5;

        System.out.println(findKthPositive(arr,k));

    }

    public static int findKthPositive(int[] arr, int k) {

        // arr = [2,3,4,7,11]
        // numbers = [1,2,3,4,5,6,7,8,9,10,11,12,13]
        //Observation- at any index, you can find missing numbers before arr[i] by just arr[i]-index-1

        int start = 0;
        int end = arr.length;
        while(start < end) {

            int mid = (start + end) / 2;

            if (arr[mid] - 1 - mid < k)
                start = mid + 1;
            else
                end = mid;
        }

        return start + k;
    }
}
