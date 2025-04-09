package BinarySearch;

public class HIndex2 {
    public static void main(String[] args) {
        int[] citations = {0,1,3,5,6};
        System.out.println("H-Index of the researcher is: " + hIndex(citations));
    }

    public static int hIndex(int[] citations) {

        int n = citations.length;

        int start = 0;
        int end = n - 1;

        int hIndex = 0;
        int ans = 0;

        while(start <= end){

            int mid = start + (end - start)/2;
            // eg [0,1,3,5,6]
            hIndex = n - mid; // current papers count eg mid = 2 and hIndex = 3, that means checking for 3 papers if citations are greater than or equal to 3

            if(citations[mid] >= hIndex){
                ans = hIndex;
                end = mid -1;
            }else{
                start = mid +1;
            }

        }

        return ans;
    }
}
