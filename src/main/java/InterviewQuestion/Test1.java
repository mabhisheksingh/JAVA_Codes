package InterviewQuestion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        /*System.out.println("Hii");
        main(null); //Throw stack overflow exception StackOverflowError*/
       List<String> list = new ArrayList<>();
       list.add("Abi");
       list.add("ABBB");
       list.add("SSSS");
       list.add("SSSS");
        list.add(new String("SSSS"));
        System.out.println(list.size());
       Iterator<String> it =  list.iterator();
       while (it.hasNext()){
           System.out.println(it.next());
       }
       for(String str : list){
           str+="XXX";
       }
        System.out.println(list);

    }
}
