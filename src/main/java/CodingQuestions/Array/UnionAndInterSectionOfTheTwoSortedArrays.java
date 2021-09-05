package CodingQuestions.Array;

public class UnionAndInterSectionOfTheTwoSortedArrays {
    public static void main(String[] args) {
        int [] a = {1, 2, 3 ,4 ,5};
        int [] b = {1, 2, 3};
        System.out.println("Do union : "+doUnion(a,5,b,3));
        System.out.println("Do Intersection : "+doIntersection(a,5,b,3));
    }
    private static boolean BST(int arr[] ,int arrSize,int target){
        int low =  0;
        int high = arrSize-1;
        if(arrSize==0)return false;
        else if(arrSize==1 ) return  (arr[0]==target)?true:false;
        else if(arrSize == 2 ) return (arr[0]== target || arr[1] == target)?true:false;
        while (low<high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target)
                return true;
            else if ( ( mid==0 || target < arr[mid] ) )
                high= mid;
            else
                low = mid+1;
        }
        if(arr[low] == target|| arr[high]==target) return true;
        return false;
    }

    public static int doUnion(int a[], int n, int b[], int m) {
        //Your code here
        int match = 0;
        int unmatch =0;
        int max= 0;
        if(n <= m){
            max = m;
            for (int i = 0; i < n; i++) {
               // System.out.println(" target "+a[i]+" Status "+BST(b,m,a[i]));
                if(BST(b,m,a[i])){
                    match++;
                }else unmatch ++;
            }
        }else {
            max  = n;
            for (int i = 0; i < m; i++) {
                //System.out.println(" target "+a[i]+" Status "+BST(b,m,a[i]));
                if(BST(a,n,b[i])){
                    match++;
                }else unmatch ++;
            }
        }
        //System.out.println("Match "+match+" UNMATCH "+unmatch +" MAX "+max);
        return match+unmatch + ( max- match);
    }

    public static int doIntersection(int a[], int n, int b[], int m) {
        //Your code here
        int match = 0;
        int unmatch =0;
        int max= 0;
        if(n <= m){
            max = m;
            for (int i = 0; i < n; i++) {
                //System.out.println(" target "+a[i]+" Status "+BST(b,m,a[i]));
                if(BST(b,m,a[i])){
                    match++;
                }else unmatch ++;
            }
        }else {
            max  = n;
            for (int i = 0; i < m; i++) {
               // System.out.println(" target "+a[i]+" Status "+BST(b,m,a[i]));
                if(BST(a,n,b[i])){
                    match++;
                }else unmatch ++;
            }
        }
        //System.out.println("Match "+match+" UNMATCH "+unmatch +" MAX "+max);
        return match;
    }
}
