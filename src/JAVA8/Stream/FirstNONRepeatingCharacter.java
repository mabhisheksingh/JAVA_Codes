package JAVA8.Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FirstNONRepeatingCharacter {
    public static void main(String[] args) {
        String list= "aaffVtffv";
        findNoNrepeatingChar(list);
    }

    private static void findNoNrepeatingChar(String input){
        Character result =  input.chars()      //string stream
                .mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i) ) ) //convert to lowercase & then to Character object
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting())) //store in a map with the count
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst().get();

        System.out.println("Result :"+result ) ;


        Object ch = input.codePoints()
                .mapToObj(x -> Character.valueOf((char) x ))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue()==1L)  //.collect(Collectors.toList());
                .findFirst().get();
//                .map(entry -> entry.getKey())
//                .findFirst().get();
        System.out.println("Result :"+ch);

        ch = input.chars()
                .mapToObj(character -> String.valueOf(character).toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .findFirst().get();
        System.out.println("Result : "+(char)ch);




    }
}
