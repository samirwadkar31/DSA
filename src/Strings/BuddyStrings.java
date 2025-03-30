package Strings;

public class BuddyStrings {
    public static void main(String[] args) {
        String s = "ab";
        String goal ="ba";
        // true
        //String s = "ab";
        //String goal ="ab";
        // false
        //String s = "aa";
        //String goal ="aa";
        // true
        System.out.println("Are they buddy strings? " + buddyStrings(s, goal));
    }

    public static boolean buddyStrings(String s, String goal) {

        if(s.length() != goal.length()) return false;

        if(s.equals(goal)){
            return checkIfBuddyStrings(s, goal);
        }

        int i = -1;
        int j = -1;
        int swap = 0;

        for(int k = 0; k < s.length(); k++){

            if(s.charAt(k) == goal.charAt(k)) continue;

            swap++;

            if(i == -1) i = k;
            else if(j == -1) j = k;

            if(swap > 2){
                return false;
            }
        }

        if(swap == 1) return false;

        if(swap == 2 && s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i)) return true;

        return false;
    }

    public static boolean checkIfBuddyStrings(String s, String goal){

        int[] alphabets = new int[26];

        for(int i = 0; i < s.length(); i++){

            alphabets[s.charAt(i) - 'a']++;

            if(alphabets[s.charAt(i) - 'a']>1){
                return true;
            }
        }
        return false;
    }
}
