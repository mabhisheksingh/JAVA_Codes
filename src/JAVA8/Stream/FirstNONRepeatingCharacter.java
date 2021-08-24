package JAVA8.Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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




        Object ch = input.chars()
                .mapToObj(cha -> Character.toLowerCase((char)cha))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream().filter(entry -> entry.getValue() == 1L)
                .findFirst().get();
        System.out.println("Result :"+ch);


    }
}
