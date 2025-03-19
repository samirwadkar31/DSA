package Array;

import java.util.Arrays;

public class HIndex1 {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5}; // other example {1,3,1}
        System.out.println("H-Index of the researcher is: " + hIndex(citations));

        // if a researcher has 100 papers and his h-index is 30. that means he is the best researcher
        // as his at least 30 papers are citated/referred by other people.
        // paper 1: 175 citations
        // paper 2: 80 citations
        // paper 3: 102 citations
        // paper 4: 40 citations
        // paper 5: 32 citations
        // .
        // .
        // paper 30: 139 citations
        // paper 31: 29 citations
        // paper 32: 15 citations

        //with above example, out of 100 papers, his 30 papers have citations more than or equal to 31
        // trick is to sort the papers based on citations
        //1,2,14,15,16,17..........29,32,40,80,102,139,175
        // then consider h as the papers and iterate through end or start anything works
        // and see at what index citations count is less than the papers
        // eg from index 0-100. at index 69 from end to start, h-papers count is 31 but citations is 29
        // which is breaking the rule hence h index is 30 here.

    }

    public static int hIndex(int[] citations) {

        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;

        for(int i = n - 1; i >= 0; i--){

            h = n - i; // current papers count

            if(citations[i] < h){ // checking if curr h papers has citations less than h.
                return h - 1;
            }
        }

        return h;
    }
}
