package InterviewQuestion.swatismita;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Infy {
    public static void main(String[] args) {
        {
            int[] arr = {5, 2, 2, 3, 2, 8};//{1,2,4,3,2,1};
            //System.out.println("output : "+program1(arr));

            int[] arr1 = {1, 5, 1};//{1,2,4,3,2,1};
            //System.out.println("output : " + program2(arr1));
        }

        int[] arr = {3,6,4,2,5,7};//{1,2,4,3,2,1};
        //System.out.println("output : "+program1(arr));

        List<Integer> arr1 = Arrays.asList(3,5,5);//{1,2,4,3,2,1};
        System.out.println("output : " + swati1(arr1));
        int[][] mat
                = { { 3, 2, 1 },
                { 6, 5, 4 },
                { 7, 8, 9 } };
        int N = mat.length;
        int M = mat[0].length;
        List<List<Integer>>  list = new ArrayList<>();
        //System.out.println( swati2(list ,N,M));
    }

    private static int swati2(List<List<Integer>> a,int n, int m){ //3,6,4,2,5,7
        int[][] mat = new int[n][m];
        for (int i=0;i< n;i++ ) {
            mat[i][0] = a.get(i).get(0);
            mat[i][1] = a.get(i).get(1);
        }
        int dp[][] = new int[n + 2][m + 2];
        for (int i = 0; i < n; i++)
            dp[i][0] = ((i - 1 >= 0) ? dp[i - 1][0] : 0) ^ mat[i][0];
        for (int j = 0; j < m; j++)
            dp[0][j] = ((j - 1 >= 0) ? dp[0][j - 1] : 0) ^ mat[0][j];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++)
            {
                int X = mat[i][j] ^ dp[i - 1][j];
                int Y = mat[i][j] ^ dp[i][j - 1];
                dp[i][j] = Math.max(X, Y);
            }
        }
        return dp[n - 1][m - 1];
    }

    private static List<Integer> swati1(List<Integer> heights){ //3,5,5
        List<Integer> list1 =  new ArrayList<>();
        for (int i =0;i<heights.size();i++) {
            int number = heights.get(i);
            int count = 0;
            int k=i-1;
            boolean firstEqual= true;
            int kTempCountMax=number;
            boolean kfirstdip= true;
            int ktemp=0;
            while(k>=0){
                int temp = heights.get(k);
                if(kTempCountMax < temp) {  //increasing order
                    count++;
                    kTempCountMax = temp;
                    kfirstdip=false;
                    firstEqual=false;
                }else if(kTempCountMax == ktemp){
                    if(firstEqual)
                        count++;
                    firstEqual= false;
                    kTempCountMax = temp;
                    kfirstdip=false;
                }
                else if(kfirstdip && kTempCountMax > temp){ //after first dip
                    if(ktemp==0){
                        count++;
                        ktemp= temp;
                    }else if (  temp >= ktemp){
                        count++;
                        ktemp=temp;
                    }
                }
                k--;
            }
            int l=i+1;
            int lTempCountMax=number;
            int templ=0;
            boolean firstdip= true;
            firstEqual= true;
            while(l < heights.size()){
                int temp = heights.get(l);
                if(lTempCountMax < temp) {  //increasing order
                    count++;
                    lTempCountMax = temp;
                    firstdip=false;
                    firstEqual= false;
                }else if(lTempCountMax == temp){
                    if(firstEqual)
                        count++;
                    firstEqual= false;
                    lTempCountMax = temp;
                    firstdip=false;
                }
               else if(firstdip && lTempCountMax > temp){ //after first dip
                    if(templ==0){
                        count++;
                        templ= temp;
                    }else if (  temp >= templ){
                        count++;
                        templ=temp;
                    }
               }
                l++;
            }
            list1.add(count);

        }
        return list1;
    }
    private static int program1(int [] arr) {
        int sum=0;
        for (int i : arr) sum+=i;
        int dividing = sum/4;
        int e1=0,e2=0,e3=0,e4=0;
        int remain =0;
        int arrLen = arr.length;
        for (int i = 0; i < arrLen; i++) {
            remain++;
            if(e1<dividing && arrLen-remain >= 3  ){e1+=arr[i]; }
            else if( e2 < dividing && arrLen-remain >= 2  ){e2+=arr[i];}
            else if(e3 <  dividing && arrLen-remain >= 1 ) {e3+=arr[i];}
            else e4+=arr[i];

        }
        System.out.println(e1+" "+e2+" "+e3+" "+e4);
        int output = Math.max( Math.max(e1,e2 ),Math.max(e3,e4 )) - Math.min( Math.min(e1,e2 ),Math.min(e3,e4 ));
        return output;
    }

    private static int program3(int [] arr){
        int prev = arr[0];
        int count =0;
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            if(prev > curr){
                count++;
                if(curr> prev) {
                    prev = curr;
                }
            }
        }
        return count;
    }

    private static int program2(int [] arr){
        int count =0;
        int temp_count=0;
        while(temp_count!=1){
            temp_count=1;
            int prev = arr[0];
            print(arr);
            for (int i = 1; i < arr.length ; i++) {
                int curr = arr[i];
                if(prev > curr){
                    temp_count=0;
                    count= count+ Math.abs(prev- curr);
                    int temp = arr[i-1];
                    int temp2 = arr[i];
                    arr[i-1]= temp2;
                    arr[i]= temp;
                }
                prev = curr;
            }
        }

        return count;
    }

    private static void print(int [] arr){
        System.out.println("---------------");
        for (int i: arr){
            System.out.print(i+" ");
        }
        System.out.println("-------------");
    }
}
