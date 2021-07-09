package hackerRrank;


public class RecursiveDigitSum {
    public static void main(String[] args) {
        String n ="9875";

        int k =100000;

        System.out.println("superDigit "+superDigit(n,k));
    }
    static int sumOfDigit(String n ,int k){
        int sum=0;
        if(k==1){
            return Integer.valueOf(n);
        }
        int lastDigit = Integer.parseInt( String.valueOf(n.charAt(k-1)));
        n = n.substring(0,n.length()-1);
        k=k-1;
        //System.out.println("N : "+n + " K : "+k + " last digit : "+ lastDigit);
        sum = sumOfDigit(n,k );
        sum = sum + lastDigit;
        return sum;
    }
    static long superDigit(String n, int k) {
        int tempMultiplierK=k;
        k = n.length();
        long sum=0;
        for(int i=0;i< n.length();i++){
            sum+=Integer.valueOf( n.charAt(i) - 48 );
        }
        //sum = sumOfDigit(n,k);
        System.out.println("SUM  : "+sum +  " K "+ tempMultiplierK);
        sum = sum*tempMultiplierK;
        System.out.println("SUM  : "+sum);
        while( (String.valueOf(sum).length() !=1)){
            k = String.valueOf(sum).length();
            n = String.valueOf(sum);
            sum = sumOfDigit(n,k);

        }
        return sum;
    }


}
