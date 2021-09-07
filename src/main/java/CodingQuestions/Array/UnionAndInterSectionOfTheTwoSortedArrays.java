package CodingQuestions.Array;

public class UnionAndInterSectionOfTheTwoSortedArrays {
    public static void main(String[] args) {
        int [] a = {1, 2, 3 ,4 ,5};
        int [] b = {1,4, 5, 6};
        System.out.println("**********Do union : ************");
        doUnion(a,5,b,4);
        System.out.println("************Do Intersection : ***********");
        doIntersection(a,5,b,4);
    }
    public static void doUnion(int[] a, int n, int[] b, int m) {
        int a1=0,b1=0;
        while(a1< n && b1 < m){
            if(a[a1] < b[b1]){
                System.out.println(a[a1++]);
            }else if( b[b1]<a[a1]){
                System.out.println(b[b1++]);
            }else{
                System.out.println(b[b1++]);
                a1++;
            }
        }
        for (int i = a1; i < n; i++) {
            System.out.println(a[i]);
        }
        for (int i = b1; i < m; i++) {
            System.out.println(b[i]);
        }
    }

    public static void doIntersection(int[] a, int n, int[] b, int m) {
        int a1=0,b1=0;
        while(a1< n && b1 < m){
            if(a[a1] < b[b1]  ){
                a1++;
            }else if( b[b1]<a[a1]){
                b1++;
            }else{
                System.out.println(b[b1++]);
                a1++;
            }
        }
    }
}
