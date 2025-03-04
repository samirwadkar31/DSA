package Design;

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers {
    public static void main(String[] args) {
        ProductOfNumbers obj = new ProductOfNumbers();

        obj.add(5);
        obj.add(2);
        obj.add(3);

        System.out.println(obj.getProduct(3));

    }
}

class ProductOfNumbers {

    List<Integer> prefixProduct;

    public ProductOfNumbers() {
        prefixProduct= new ArrayList<>();
        prefixProduct.add(1);
    }

    public void add(int num) {

        if(num==0){
            prefixProduct.clear();
            prefixProduct.add(1);
        }else{
            prefixProduct.add(prefixProduct.get(prefixProduct.size()-1)*num);
        }

    }

    public int getProduct(int k) {

        int size= prefixProduct.size();

        if(k>=size) return 0;

        return prefixProduct.get(size-1)/prefixProduct.get(size-k-1);

    }
}
