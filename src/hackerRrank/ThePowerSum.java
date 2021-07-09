package hackerRrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ThePowerSum {
    public static void main(String[] args) {
        int X= 100;
        int N = 3;
        int num=1;

        System.out.println(" Power Sum : "+powerSum(num,X,N));
    }



    private static int powerSum(int num, int x, int power) {
        int var =(int) Math.pow(num,power);
        if(var < x ){
            System.out.println("pre num ; "+ num + " x : "+ x );
            int no = powerSum(num+1,x,power) + powerSum(num+1 ,x-var,power);
            System.out.println("aft num ; "+ num + " x : "+ x + " no "+no );
            return no;
        }

        if(var == x ){
            return 1;
        }else{
            return 0;
        }
    }

    public static int powerSum(int X, int N) {
        // Write your code here
        int arrSize =  (int) Math.floor(Math.sqrt(X) ) ;
        int arr1[] = new int[arrSize];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i =1 ;i<= arrSize;i++){
            arr1[i-1]= i;
            arr.add(i);
        }
        System.out.println("Arr : "+ arr  +" X : "+X+" N : "+N  );
        int arrSizereturn = countSubSetArr(arr1,X,N);
       // return new ThePowerSum().countSubSet(arr, X,N);
        return arrSizereturn;
    }

    private static int countSubSetArr(int[] arr1, int x, int power) {
        if(arr1.length != 0 && x >0 ){
            int lNo = arr1.length;
            int powercal = (int)Math.pow(lNo,power);
            //System.out.println("Power Calc  : "+ powercal);
            arr1 = Arrays.copyOfRange(arr1, 0, arr1.length-1 );
            for(int i = 0 ; i< arr1.length;i++){
                //System.out.print(arr1[i]+" ");
            }
           // System.out.println();
            return countSubSetArr( arr1 , x- powercal , power ) + countSubSetArr(arr1 , x , power);
        }
        if(x == 0){ return 1; }
        else { return 0; }

    }

    public int countSubSet(ArrayList<Integer> arr,int X ,int power){
        if(  (!arr.isEmpty() && X > 0) && arr.get(0) != -100000 ){
            int lastNo = arr.get(arr.size() - 1);
            if(arr.size() ==1 ){
                arr.set(0,-100000);
                //arr.add();
            }else{
                arr.remove(arr.size() - 1);
            }
            //arr.remove(arr.size() - 1);
            System.out.println("lastNo  " + lastNo );
            System.out.println("pre Arr remove : "+ arr + " X-pow : "+(int) (X- Math.pow(lastNo,power ) )  +" N : "+power  + " X : "+X+"LN  "+lastNo);
           // System.out.println("pre Arr remove : "+ arr + " X : "+(int) (X- Math.pow(lastNo,N ) )  +" N : "+N  + " Count : ");
            int LnoSquare = (int) Math.pow(lastNo, power);
            int temp= countSubSet(arr , X - LnoSquare ,power ) +  countSubSet(arr , X ,power );
            System.out.println("temp : "+  temp);
            return temp;
        }
        if(X == 0){ return 1; }
        else if(arr.get(0) == -100000  || X < 0 ){ return 0; }
        else { return 99;}
    }



}
