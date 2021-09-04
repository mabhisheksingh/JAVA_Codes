package InterviewQuestion;

import java.util.Arrays;
import java.util.List;

class Foo{

    class FooA{
        int a =25;
    }
}
public class AccesInnerClass {
    public static void main(String[] args) {
        Foo foo = new Foo();
       // Foo.FooA f = new Foo.FooA(); if FooA is static class
        Foo.FooA f =foo.new FooA(); //if FooA is not static class
        System.out.println(f.a);
        StreamQuestion();
    }

    private static void StreamQuestion() {
        List<Integer> list = Arrays.asList(1,2,4,5,7,10,11,13,16);
        int total = list.stream().filter(i -> i%3==1).map( c -> c*c +2).reduce(0,Integer::sum);
        System.out.println("Total  : "+(total/2 )/2);
    }
}
