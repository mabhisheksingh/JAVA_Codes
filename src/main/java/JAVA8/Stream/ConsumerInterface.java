package JAVA8.Stream;

import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerInterface {
    static void printMessage(String name){
        System.out.println("Hello "+name);
    }
    static void printValue(int val){
        System.out.println(val);
    }
    public static void main(String[] args) {
        // Referring method to String type Consumer interface
        Consumer<String> consumer1 = ConsumerInterface::printMessage;
        consumer1.accept("John");   // Calling Consumer method
        // Referring method to Integer type Consumer interface
        Consumer<Integer> consumer2 = ConsumerInterface::printValue;
        consumer2.accept(12);   // Calling Consumer method
       // Function
    }
}
