package InterviewQuestion.amdocs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//sorting with the help of stream api
public class Questions {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(100,1,0,-1,3,40);
        list.stream().sorted().forEach(System.out::println);
        list.stream().filter(i -> i>=30).forEach(System.out::println);

        String str ="Abhishek";
        String s1= "shek";
        String s2 = "abcd";
        System.out.println();
        int max = list.stream().max( (a,b)->{
            if(a >b)
                return -1;
            return 1;
        }).get();

        System.out.println("max : "+ max);
    }
}
