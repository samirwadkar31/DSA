package TwoPointers;

public class LongestMountainInArray {

    public static void main(String[] args) {
        int[] arr = {2,1,4,7,3,2,5};
        System.out.println("Longest Mountain Length In Array: " + longestMountain(arr));
    }

    public static int longestMountain(int[] arr) {

        int n = arr.length;
        int maxLength = 0;

        for(int i = 1; i < n - 1; i++){
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]){
                int left = i, right = i;

                while(left > 0 && arr[left] > arr[left - 1]){
                    left--;
                }

                while(right < n - 1 && arr[right] > arr[right + 1]){
                    right++;
                }

                if(right - left + 1 >= 3){
                    maxLength = Math.max(maxLength, right - left + 1);
                }
            }
        }

        return maxLength;
    }
}
