package JAVA8.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

///Input->>>> AABBCCAA
///OutPut->>> A2B2C2A2
public class RaghavStringProblem1 {
    public static void main(String[] args) {

        List<String> str=new ArrayList();
        str.add("AABBCCDD");
        str.add("ACaAAA");
        System.out.println(output(str));
    }

    private static String output(List str) {

        Object stream1=str.stream().map(new Function<String , String>() {
            @Override
            public String apply(String s) {
                String o="";
                int count=1;
                System.out.println("String "+s);
                for(int i=1;i<s.length();i++){
                    if(s.charAt(i-1)==s.charAt(i)){
                        count++;
                    }else{
                        o+=s.charAt(i-1);
                        o=o+count;
                        count=1;
                    }
                }
                o+=s.charAt(s.length()-1);
                o=o+count;
                count=1;

                return o;
            }
        }).collect(Collectors.toList());
        //System.out.println(stream1.toString());
        return stream1.toString();
    }
}
