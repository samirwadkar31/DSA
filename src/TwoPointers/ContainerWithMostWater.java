package TwoPointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height= {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {

        int n= height.length;
        int maxwater= 0;

        int start= 0;
        int end= n-1;

        while(start<end){
            int water= (end-start)*Math.min(height[start],height[end]);
            maxwater= Math.max(water, maxwater);

            if(height[start]<height[end]){
                start++;
            }else{
                end--;
            }
        }

        return maxwater;

    }
}
