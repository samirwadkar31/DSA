package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {

        TimeMap timeMap = new TimeMap();

        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));  // Output: "bar"
        System.out.println(timeMap.get("foo", 3));  // Output: "bar"
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));  // Output: "bar2"
        System.out.println(timeMap.get("foo", 5));  // Output: "bar2"

    }
}

class pair {
    String value;
    int timestamp;

    public pair(String value, int timestamp){
        this.value=value;
        this.timestamp=timestamp;
    }
}

class TimeMap {

    public HashMap<String, List<pair>> map;

    public TimeMap() {
        map= new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            pair p= new pair(value, timestamp);
            List<pair> tempList= new ArrayList<>();
            tempList.add(p);
            map.put(key, new ArrayList<>(tempList));
        }else{
            map.get(key).add(new pair(value, timestamp));
        }

    }

    public String get(String key, int timestamp) {

        if(!map.containsKey(key)) return "";

        List<pair> list= map.get(key);

        int start=0;
        int end= map.get(key).size()-1;

        while(start<=end){
            int mid= start+(end-start)/2;

            if(list.get(mid).timestamp==timestamp) return list.get(mid).value;
            else if(list.get(mid).timestamp<timestamp) start=mid+1;
            else end=mid-1;
        }

        return end>=0 ? list.get(end).value: "";
    }
}

