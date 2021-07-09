package JAVA8.Stream;

import java.util.stream.Stream;

public class JavaStreamIteratingExample {
    public static void main(String[] args) {
        Stream.iterate(1, no-> no+1).filter(no -> no%5==0).limit(5).forEach(System.out::println);
    }
}
