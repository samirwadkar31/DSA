package DifferenceArray;

public class ShiftingLetters2 {
    public static void main(String[] args) {

        String s= "abc";
        int[][] shifts= {{0,1,0},{1,2,1},{0,2,1}};
        System.out.println(shiftingLetters(s, shifts));

    }
    public static String shiftingLetters(String s, int[][] shifts) {
        int n= s.length();
        int[] diff= new int[n+1];

        for(int[] shift: shifts){            // building diff array
            if(shift[2]==0){
                diff[shift[0]]+=-1;
                diff[shift[1]+1]-=-1;
            }else if(shift[2]==1){
                diff[shift[0]]+=1;
                diff[shift[1]+1]-=1;
            }
        }

        for(int i=1; i<n; i++){              // building prefix sum
            diff[i]=diff[i]+diff[i-1];
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            diff[i]= diff[i]%26;
            if(diff[i]<0){
                diff[i]= diff[i]+26;
            }
            sb.append((char)((s.charAt(i)-'a'+ diff[i])%26 +'a'));
        }
        return sb.toString();
    }
}
