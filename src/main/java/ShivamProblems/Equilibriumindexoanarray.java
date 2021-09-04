package ShivamProblems;
//Cheating kiya hu
/*Example :
Input: A[] = {-7, 1, 5, 2, -4, 3, 0}
Output: 3
3 is an equilibrium index, because:
 A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
Input: A[] = {1, 2, 3}
Output: -1
*/
public class Equilibriumindexoanarray {
    public static void main(String[] args) {
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        boolean exit =findEquilibriumindexoanarray(arr);
    }

    private static boolean findEquilibriumindexoanarray(int[] arr) {
        int sum =0;
        int leftsum =0;
        for(int i : arr) sum+=i;
        for(int  i=0;i< arr.length;i++){
            sum-=arr[i];
            if(sum == leftsum){
                System.out.println("Eqilibrium point is : " +i);
                return true;
            }
            leftsum+=arr[i];
        }
        System.out.println("Not Exist Equilibrium in Array ");
        return false;
    }
}
