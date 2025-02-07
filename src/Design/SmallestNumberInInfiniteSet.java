package Design;
import java.util.*;

public class SmallestNumberInInfiniteSet {
    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();

        smallestInfiniteSet.addBack(2); // 2 is already in the set, so no change is made.
        System.out.println(smallestInfiniteSet.popSmallest()); // Output: 1
        System.out.println(smallestInfiniteSet.popSmallest()); // Output: 2
        System.out.println(smallestInfiniteSet.popSmallest()); // Output: 3
        smallestInfiniteSet.addBack(1); // 1 is added back to the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // Output: 1
        System.out.println(smallestInfiniteSet.popSmallest()); // Output: 4
        System.out.println(smallestInfiniteSet.popSmallest()); // Output: 5
    }
}

class SmallestInfiniteSet {
    private TreeSet<Integer> set;
    private int current;

    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        current = 1;
    }

    public int popSmallest() {
        if (set.size()==0) {
            return current++;
        } else {
            return set.pollFirst();
        }
    }

    public void addBack(int num) {
        if (num < current && !set.contains(num)) {
            set.add(num);
        }
    }
}
