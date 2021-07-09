package JAVA8.Stream;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

///Input->>>> AABBCCAA
///OutPut->>> A2B2C2A2
public class RaghavStreamInterviewQuestion1 {
    public static void main(String[] args) {
        String str = "AABBCCAA";
        System.out.println("\nInput : "+str+"\nOutput : "+convert(str));
    }

    private static String convert(String str) {
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
}
