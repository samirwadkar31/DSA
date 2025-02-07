package Design;

import java.util.HashMap;

public class DesignParkingSystem {
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);

        System.out.println(parkingSystem.addCar(1)); // true
        System.out.println(parkingSystem.addCar(2)); // true
        System.out.println(parkingSystem.addCar(3)); // false
        System.out.println(parkingSystem.addCar(1)); // false
    }
}

class ParkingSystem {

    int big;
    int medium;
    int small;
    HashMap<Integer, Integer> map;

    public ParkingSystem(int big, int medium, int small) {
        this.big=big;
        this.medium=medium;
        this.small=small;

        map= new HashMap<>();
        map.put(1, big);
        map.put(2, medium);
        map.put(3, small);

    }

    public boolean addCar(int carType) {
        if(map.get(carType)>0){
            map.put(carType, map.getOrDefault(carType,0)-1);
            return true;
        }else{
            return false;
        }
    }
}

