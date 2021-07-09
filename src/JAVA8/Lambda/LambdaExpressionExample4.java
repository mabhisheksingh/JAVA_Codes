package JAVA8.Lambda;

interface Sayable{
    //String say(String name);
    default void say1(String name, int a){
        System.out.println();
    } ///for default case we must body in Interface
    String say2(String name, int b);
}

public class LambdaExpressionExample4{
    public static void main(String[] args) {

        /*// Lambda expression with single parameter.
        Sayable s1=(name)->{
            return "Hello, "+name;
        };
        System.out.println(s1.say("Sonoo1"));

        // You can omit function parentheses
        Sayable s2= name ->{
            return "Hello, "+name;
        };
        System.out.println(s2.say("Sonoo"));*/

        // Lambda expression with dual parameter.
        Sayable s3=(name,i)->{
            return "Hello, "+name+i;
        };
        System.out.println(s3.say2("Sonoo1" , 56));
    }
}