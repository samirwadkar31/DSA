package BinarySearch;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {

        char[] letters= {'a','z'};
        char target = 'y';
        System.out.println("Next Greatest Letter: " + nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        int start=0;
        int end= letters.length-1;
        int mid=0;

        if(target<letters[0]){
            return letters[0];
        }

        if(target>=letters[letters.length-1]){
            return letters[0];
        }

        while(start<=end){

            mid= start +(end-start)/2;

            if(target<letters[mid]){
                end=mid-1;
            }else if(target>=letters[mid]){
                start=mid+1;
            }

        }

        return letters[start];
    }
}
