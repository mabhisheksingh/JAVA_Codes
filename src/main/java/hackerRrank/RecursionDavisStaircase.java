package hackerRrank;

/*
181997601 = 32
334745777 = 33
1132436852 = 35
2082876103 = 36
2082876103 = 36
 */
public class RecursionDavisStaircase {
    public static void main(String[] args){
        int n = 8;
        int arr[] = {1,2,3};
        //int no1 = stepPerms1(arr,n) ;
        int no  = stepPerms(n);
        long  number = no % 10000000007L;
        System.out.println( " Number  : "+ number);
    }

    //Dynamic Programing
    private static int stepPerms(int n) {
        if( n == 0 || n == 1 ) return 1;
        if( n== 2)  return 2;
        int []arr = new int[n+1];
        arr[0] = 1; arr[1] = 1 ; arr[2] = 2;
        for( int i =3 ; i<=n ;i++)
            arr[i] = arr[i-3] + arr[i -2]+ arr[i-1];
        return arr[n];

    }

    //Recursion Method
    public static int stepPerms1(int [] arr,int n) {
        // Write your code here
        if (n == 0  || n ==1 ) return 1;
        if (n < 0) return 0;

        return stepPerms1(arr, n - arr[0]) + stepPerms1(arr, n - arr[1]) + stepPerms1(arr, n - arr[2]);
    }
}
