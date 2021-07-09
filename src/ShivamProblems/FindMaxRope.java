package ShivamProblems;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/*I/P: n=5, a=2, b=5, c=1
        O/P: 5
//We make 5 pieces of length 1 each

        I/P: n=23, a=12, b=9, c=11
        O/P: 2
//We make 2 pieces of length 11 and 12

        I/P: n=5, a=4, b=2, c=6
        O/P: -1
//Not possible */
public class FindMaxRope {

    public static void main(String[] args) {
        int n = 11;
        int a = 4;
        int b = 2;
        int c = 5;
        System.out.println("N : "+ n);
        findmax(n,a,b,c);



    }

    private static void findmax(int n, int a, int b, int c) {
        int max=-1;

        /*if(n<(a+b+c)){

        }else if(a > n ){

        }else if( b > n){

        }else if( c > n){

        }*/

        if(n%a==0){
            max= n/a;
        }
        if(n%b== 0 && n/b>max){
            max= n/b;
        }
        if(n%c== 0 && n/c>max){
            max= n/c;
        }

        System.out.println("C MAX : "+max);
        Map<Integer,String> hash = new HashMap<Integer,String>();

        hash.put(a,String.valueOf(a));
        if(hash.containsKey(b)){
            String temp = hash.get(b);
            hash.remove(b);
            hash.put(b,temp+","+String.valueOf(b));
        }else{
            hash.put(b,String.valueOf(b));
        }
        if(hash.containsKey(c)){
            String temp = hash.get(c);
            hash.remove(c);
            hash.put(c,temp+","+String.valueOf(c));
        }else{
            hash.put(c,String.valueOf(c));
        }
        System.out.println("HASH : "+hash);

        int tempmax= -1;
        for(Integer integer : hash.keySet()){
            if(!hash.get(integer).contains(",")){
               // tempmax=0;
                for(int i=1 ; i*integer<n ; i++){
                    int temp1= n - (integer * i);
                    if(hash.containsKey( temp1 )){
                        tempmax=tempmax+ ((integer * i)/integer ) +1;
                        System.out.println("temp "+ tempmax +" i: "+i+" intr"+integer + " n "+n);
                        break;
                    }
                }
            }else{

            }
        }

        if(tempmax > max){
            System.out.println("TempMax : "+ tempmax);
        }else{
            System.out.println("Max : "+ max);
        }

    }

}
