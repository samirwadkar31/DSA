package Design;

import java.util.HashMap;

public class LoggerRateLimiter {
    public static void main(String[] args) {

        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
        System.out.println(logger.shouldPrintMessage(2, "bar"));  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
        System.out.println(logger.shouldPrintMessage(3, "foo"));  // 3 < 11, return false
        System.out.println(logger.shouldPrintMessage(8, "bar"));  // 8 < 12, return false
        System.out.println(logger.shouldPrintMessage(10, "foo")); // 10 < 11, return false
        System.out.println(logger.shouldPrintMessage(11, "foo")); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
    }
}

class Logger {

    HashMap<String, Integer> map;

    public Logger() {
        map= new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            if(timestamp>=map.get(message)){
                int newtime= timestamp+10;
                map.put(message, newtime);
                return true;
            }else{
                return false;
            }
        }else{
            int time= timestamp+10;
            map.put(message, time);
            return true;
        }
    }
}
