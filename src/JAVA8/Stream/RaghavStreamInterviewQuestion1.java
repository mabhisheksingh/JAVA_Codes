package JAVA8.Stream;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

///Input->>>> AABBCCAA
///OutPut->>> A2B2C2A2
public class RaghavStreamInterviewQuestion1 {
    public static void main(String[] args) {
        String str = "AABBCCAA";
        //System.out.println("\nInput : "+str+"\n convert Output : "+convert(str));
        System.out.println("\nInput : "+str+"\nfindConsequtiveSequenceOfChar Output : "+findConsequtiveSequenceOfChar(str));
    }

    /*private static String convert(String str) {
        Map<Character,Long> map = str.chars()
                .mapToObj(ch -> Character.toLowerCase(Character.valueOf((char) ch) ) )
                .collect(Collectors.groupingBy(chars ->chars,Collectors.counting()) );

               // .forEach( (k,v) -> System.out.print((char)k+ String.valueOf(v )));
        str="";
        for (Map.Entry<Character, Long> o : map.entrySet()){
            str=str+o.getKey()+o.getValue();
        }
        System.out.println("b : "+map);
        return str;
    }
*/
    private static String findConsequtiveSequenceOfChar(String str){
        System.out.println("Sorted : ");
        str.chars().sorted().forEach(ch -> System.out.print((char)ch+" " ));
        System.out.println("Distinct : ");
        str.chars().distinct().forEach(ch -> System.out.print((char)ch+" " ));
        Map<Character,Long> map= str.chars()
                .mapToObj(ch -> Character.toLowerCase( (char) ch)  )
                .collect(Collectors.groupingBy(chars -> chars,Collectors.counting()) );
        str="";
        for (Map.Entry<Character, Long> o : map.entrySet()){
            str=str+o.getKey()+o.getValue();
        }

        return str;
    }
}
