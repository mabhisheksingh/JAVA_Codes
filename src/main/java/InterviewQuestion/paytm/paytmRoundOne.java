package InterviewQuestion.paytm;

public class paytmRoundOne {
    public static void main(String[] args) {
        int []arr = {0,1,1,1,0,2,0,0,0,0,2,2,2,2,1,1,1,1,0};
        //output : {0,0,1,1,1,2}
        //sort1(arr);
        arr = sort(arr);
        arr = sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        int [] stock  = {2,7,1,9}; //output 8 //0
       System.out.println("\nStick price : "+  findstock(stock));
    }

    private static int[] sort(int[] arr) {

        int leftflag=0;
        int rightFlag = arr.length-1;
        for (int i = 0; i <=rightFlag; i++) {
            if(arr[i]==0){
                arr = swap(arr,leftflag,i);
                leftflag++;
            }else if( arr[i] ==2){
                arr = swap(arr,rightFlag,i);
                rightFlag--;
            }
        }
        return arr;
    }

    private static int findstock(int[] stock) {
        int max =0;
        int premaax =0;
        for (int i = 1; i < stock.length; i++) {
            if(stock[i] > stock[i-1]){
                max += stock[i]-stock[i-1];
            }else{
                if(premaax <max){
                    premaax = max;
                    max =0;
                }
            }
        }
        if(premaax <max){
            premaax = max;
        }
        System.out.println("premax : "+premaax +" max  : "+max);

        return max;
    }

    private static void sort1(int[] arr) {
        int leftflag =0;
        int rightFlag= arr.length-1;

        for (int i = 0; i < rightFlag; i++) {
            if(arr[i]==0){
               arr = swap(arr,leftflag,i);
               leftflag++;
            }else if( arr[i] ==2){
                arr = swap(arr,rightFlag,i);
                rightFlag--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static int[]  swap(int[] arr, int leftflag, int i) {
        int left  = arr[leftflag];
        arr[leftflag ]= arr[i];
        arr[i] = left;
        return arr;

    }




}
