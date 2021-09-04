package JAVA8.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//print even odd with the help of Stream
public class Class1 {
    public static void main(String[] args) {
        List<Integer> list1=new ArrayList<>();

        for(int i=0;i<99;i++){
            list1.add(i);
        }

        List stream1=list1.stream().filter(i -> (i<45 && i>12)).collect(Collectors.toList());
        System.out.println(stream1);

        List stream2=list1.stream().map(i -> i+=1 ).collect(Collectors.toList());
        System.out.println(stream2);

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

//get count of empty string
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);

        List<String> strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings1.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("Filtered List: " + filtered);
        String mergedString = strings1.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);
    }
}
