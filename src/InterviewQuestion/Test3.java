package InterviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add(new String("123"));
        list.add(new String("456"));
        list.add(new String("789"));
        System.out.println(list.size());
        if(list.contains(new String("123"))){
            System.out.println("true");
        }
        System.out.println( list.remove(new String("123")));
        System.out.println(list.size());
        System.out.println(list);
    }
}
