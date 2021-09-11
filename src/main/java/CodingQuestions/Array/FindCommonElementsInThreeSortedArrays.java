package CodingQuestions.Array;
/*
* Given three arrays sorted in non-decreasing order, print all common elements in these arrays.
Examples:
Input:
ar1[] = {1, 5, 10, 20, 40, 80}
ar2[] = {6, 7, 20, 80, 100}
ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20, 80

Input:
ar1[] = {1, 5, 5}
ar2[] = {3, 4, 5, 5, 10}
ar3[] = {5, 5, 10, 20}
Output: 5, 5
* */
public class FindCommonElementsInThreeSortedArrays {
    public static void main(String[] args) {
        int []ar1 = {1, 5, 7, 10, 20, 40, 80};
        int []ar2 = {6, 7, 20, 80, 100};
        int []ar3 = {3, 4, 7, 15, 20, 30, 70, 80, 120};
        
        findCommom(ar1,ar2,ar3);
    }

    private static void findCommom(int[] ar1, int[] ar2, int[] ar3) {
        int a1=0,a2=0,a3=0;
        while (a1 <ar1.length && a2 <  ar2.length && a3 < ar3.length){
            if(ar1[a1] < ar2[a2] && ar1[a1] < ar3[a3]) a1++;
            else if( ar2[a2] < ar1[a1] && ar2[a2] < ar3[a3] ) a2++;
            else if( ar3[a3] < ar1[a1] && ar3[a3] < ar2[a2] ) a3++;
            else{
                System.out.print(ar1[a1++]+" ");
                a2++;a3++;
            }
        }
    }
}
