package HashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        //
        int[] ans = intersection(nums1, nums2);

        System.out.println("Intersection Of Two Arrays: ");

        for(int num: ans){
            System.out.print(num + ", ");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set= new HashSet<>();
        List<Integer> list= new ArrayList<>();

        for(int num: nums1){
            set.add(num);
        }

        for(int num: nums2){
            if(set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }

        int[] ans= new int[list.size()];

        for(int i=0; i<list.size(); i++){
            ans[i]= list.get(i);
        }

        return ans;
    }
}
