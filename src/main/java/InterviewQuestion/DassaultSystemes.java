package InterviewQuestion;

import java.util.HashMap;

public class DassaultSystemes {

    private static void A(String str){
        System.out.println("String");
    }
    private static void A(Object str){
        System.out.println("Object");
    }
    private static void A(Integer str){
        System.out.println("Integer");
    }

    private static void B(Exception str){
        System.out.println("Exception");
    }
    private static void B(Object str){
        System.out.println("Object");
    }
    private static void B(ArithmeticException str){
        System.out.println("ArithmeticException");
    }
    private static void B(ArrayIndexOutOfBoundsException str){
        System.out.println("ArrayIndexOutOfBoundsException");



    }

    //how to access static variable inside non-static method
    private static String str1  ="";
    private void temp(){

        str1 = "23";

    }

    //How we can use not static variable inside  static block with the help of Object reference
    private String str ="";
    private static void temp1(){
        DassaultSystemes d = new DassaultSystemes();
        d.str="A";
    }


    //make final method and final variable in below method
    public static final void temp3(){
        final String str = "AA";
    }
    public static void temp4(){
        final String str = "AA";
    }


    public static void main(String[] args) {
       // A(null); throw exception
        //B(null); //throw exception
        //if we use only exception and one child exception overload then it did not throw any exception but
        // if we use two child exception then it throw compiler time error
        HashMap m = new HashMap();
        Object o1 = new Object();
        Object o2 = o1;
        m.put(o1,1);
        m.put(o2,2);
        System.out.println("H "+ m +" size "+ m.size());

    }
    //String pool concept and Volatile in java

}
