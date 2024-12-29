package BinarySearch;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] a= {1,2,4};
        int[] b= {3,5,7};
        System.out.println(findMedian(a,b));
    }

    public static double findMedian(int[] a, int[] b){
        int n1= a.length;
        int n2= b.length;

        if(n1>n2) return findMedian(b, a);

        int start=0;
        int end= n1-1;

        while(start<=end){
            int mid1= start+(end-start)/2;
            int mid2= (n1+n2+1)/2-mid1;

            int l1= Integer.MIN_VALUE;
            int l2= Integer.MIN_VALUE;
            int r1= Integer.MAX_VALUE;
            int r2= Integer.MAX_VALUE;

            if(mid1<=n1) r1= a[mid1];
            if(mid2<=n2) r2= b[mid2];
            if(mid1-1>=0) l1= a[mid1-1];
            if(mid2-1>=0) l2= b[mid2-1];

            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==0){
                    return (double)(((Math.max(l1,l2)+Math.min(r1,r2))/2.0));
                }else{
                    return Math.max(l1,l2);
                }
            }else if(l1>r2){
                end= mid1-1;
            }else{
                start= mid1+1;
            }
        }

        return -1;
    }

}









