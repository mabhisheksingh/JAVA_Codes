package ShivamProblems;

public class TralingZeroOfactorial {
    public static void main(String[] args) {
        int no = 100;
        System.out.println(findTrailingZero(no));
    }

    private static int findTrailingZero(int no) {
        if(no < 0){
            return -1;
        }else if( no < 5){
            return 0;
        }
        int count = 0;
        for( int i =5 ;i <= no ;i*=5){
            count = count + no/i;
        }

        return count;
    }
}
