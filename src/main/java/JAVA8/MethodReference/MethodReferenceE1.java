package JAVA8.MethodReference;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@FunctionalInterface
interface Parse{
    public String parse(String s);
}

class StringParse{
    public static String convert(String s){
        if(s.length() <=3 ) return s.toLowerCase();
        else return  s.toUpperCase();
    }
}
class MyPrint{
    public void print(String str,Parse p){
        str = p.parse(str);
        System.out.println(str);
    }
}
public class MethodReferenceE1 {
    public static void main(String[] args) {
        //Example 1
        List<String> list = Arrays.asList("Abhishek","Ashish");
        //list.forEach(System.out::println); //Call by Method

        //Example2
        String str = "Addb";
       /* new MyPrint().print(str, new Parse() {
            @Override
            public String parse(String s) {
                if(s.length() <=3 ) return s.toLowerCase();
                else return  s.toUpperCase();
            }
        });*/
        //new MyPrint().print(str ,( s -> StringParse.convert(s) ) );
        new MyPrint().print(str , StringParse::convert );

    }
}
