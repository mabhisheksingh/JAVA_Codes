package InterviewQuestion.paytm;

import java.util.HashMap;
import java.util.Map;

public class ROUNDTWO {
    static Map<String ,String> hash ;
    static int counter = 0;
    public static void main(String[] args) {
        String str = "Abhishek";

        String out ="";//Cache.cache(str);

        if(out.equalsIgnoreCase("New data inserted")){
            System.out.println("New data inserted : "+out);
        }else
            System.out.println(out);
       // out =Cache.cache(str);

        if(out.equalsIgnoreCase("New data inserted")){
            System.out.println("New data inserted : "+out);
        }else
            System.out.println(out);



        Student std = new Student();
        Long id =100L;
        std.setStdId(id);
        std.setStdName("Abhishek");
        std.setStrFathername("ram Singh");
      // counter++;
        String out1 =Cache.cache(id,std,counter++);
        out1 = Cache.cache(id,std,counter++);
        out1 = Cache.cache(id,std,counter++);
        out1 = Cache.cache(id,std,counter++);
        out1 = Cache.cache(id,std,counter++);
        out1 = Cache.cache(id,std,counter++);
        System.out.println("Counter : "+counter);
        System.out.println(out1);
        out1 =Cache.cache(id,std);
        System.out.println(out1);

        int x= 'a';
        int y ='z';
        System.out.println(x +" "+y);

    }
}
